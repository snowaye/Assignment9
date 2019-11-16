package com.padc.batch9.assignment9.data.model

import com.padc.batch9.assignment9.data.vo.UserVo
import com.padc.batch9.assignment9.network.PlantApi
import com.padc.batch9.assignment9.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object UserModelImpl: BaseModel(), UserModel {

    override fun getUser(): List<UserVo> {
        return database.userDao().getAllUser()
    }


    override fun loginUser(
        email: String,
        password: String,
        onSuccess: (UserVo) -> Unit,
        onFailure: (String) -> Unit
    ) {
       dataAgent.login(email, password,
           {
                database.userDao().insertUser(it)
               onSuccess(it)
           },
           onFailure)
    }


    override fun getUser(
        email: String,
        password: String,
        onSuccess: (UserVo) -> Unit,
        onFailure: (String) -> Unit
    ) {

        dataAgent.getUserData(email, password,
            {
                database.userDao().insertUser(it)
                onSuccess(it)
            }, onFailure
            )
    }

    private val plantApi: PlantApi

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