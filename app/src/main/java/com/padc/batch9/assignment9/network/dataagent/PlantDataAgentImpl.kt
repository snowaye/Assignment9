package com.padc.batch9.assignment9.network.dataagent

import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.network.PlantApi
import com.padc.batch9.assignment9.network.response.GetPlantResponse
import com.padc.batch9.assignment9.util.BASE_URL
import com.padc.batch9.assignment9.util.EM_NULL_PLANT_RESPONSE
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object PlantDataAgentImpl: PlantDataAgent {

    override fun getPants(onSuccess: (List<PlantVo>) -> Unit, onFailure: (String) -> Unit) {
        val call = plantApi.getAllPlants()
        call.enqueue(object  : Callback<GetPlantResponse> {

            override fun onFailure(call: Call<GetPlantResponse>, t: Throwable) {
                onFailure(t.localizedMessage)
            }
            override fun onResponse(
                call: Call<GetPlantResponse>,
                response: Response<GetPlantResponse>
            ) {
                val plantResponse = response.body()
                if (plantResponse != null){
                    if(plantResponse.data != null){
                        onSuccess(plantResponse.data)
                    }else{
                        onFailure(plantResponse.message)
                    }
                }else{
                    onFailure(EM_NULL_PLANT_RESPONSE)
                }
            }
        })
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