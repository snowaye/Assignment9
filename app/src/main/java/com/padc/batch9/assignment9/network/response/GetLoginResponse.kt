package com.padc.batch9.assignment9.network.response

import com.google.gson.annotations.SerializedName
import com.padc.batch9.assignment9.data.vo.UserVo
import com.padc.batch9.assignment9.util.CODE_RESPONSE_OK

class GetLoginResponse (
    @SerializedName("code")
    val code:Int,

    @SerializedName("message")
    val message:String,

    @SerializedName("data")
    val userData:UserVo?
) {
    fun isResponseOK():Boolean {
        return code == CODE_RESPONSE_OK && userData!=null
    }
}