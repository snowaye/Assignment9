package com.padc.batch9.assignment9.network.dataagent

import com.padc.batch9.assignment9.data.vo.UserVo
import com.padc.batch9.assignment9.network.PlantApi
import com.padc.batch9.assignment9.network.response.GetLoginResponse
import com.padc.batch9.assignment9.util.BASE_URL
import com.padc.batch9.assignment9.util.EM_NULL_USER_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object UserDataAgentImpl: UserDataAgent {
    override fun getUserData(
        email: String,
        password: String,
        onSuccess: (UserVo) -> Unit,
        onFailure: (String) -> Unit
    ) {
        val call = plantApi.loginUser(email, password)
        call.enqueue(object  : Callback<GetLoginResponse> {
            override fun onFailure(call: Call<GetLoginResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<GetLoginResponse>,
                response: Response<GetLoginResponse>
            ) {
                val loginResponse = response.body()
                if (loginResponse != null){
                    if(loginResponse.userData != null){
                        onSuccess(loginResponse.userData)
                    }else{
                        onFailure(loginResponse.message)
                    }
                }else{
                    onFailure(EM_NULL_USER_RESPONSE)
                }
            }
        })
    }

    private val plantApi:PlantApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        plantApi = retrofit.create(PlantApi::class.java)
    }


}




