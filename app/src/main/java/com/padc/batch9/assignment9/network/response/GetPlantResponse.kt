package com.padc.batch9.assignment9.network.response

import com.google.gson.annotations.SerializedName
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.util.CODE_RESPONSE_OK

class GetPlantResponse (
    @SerializedName("message")
    val message:String,

    @SerializedName("code")
    val code:Int,

    @SerializedName("data")
    val data:List<PlantVo>
) {
    fun isResponseOK(): Boolean{
        return code == CODE_RESPONSE_OK && data!= null
    }
}