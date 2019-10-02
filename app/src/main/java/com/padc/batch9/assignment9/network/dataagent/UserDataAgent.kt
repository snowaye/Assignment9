package com.padc.batch9.assignment9.network.dataagent

import com.padc.batch9.assignment9.data.vo.UserVo

interface UserDataAgent {

    fun getUserData(email:String, password:String, onSuccess: (UserVo) -> Unit, onFailure:(String) -> Unit)
}