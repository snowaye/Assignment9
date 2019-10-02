package com.padc.batch9.assignment9.network

import com.padc.batch9.assignment9.network.response.GetLoginResponse
import com.padc.batch9.assignment9.util.LOGIN
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PlantApi {

    @POST(LOGIN)
    @FormUrlEncoded
    fun loginUser(email:String, password:String): Call<GetLoginResponse>
}