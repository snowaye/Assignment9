package com.padc.batch9.assignment9.data.model

import com.padc.batch9.assignment9.data.vo.UserVo

interface UserModel {

    fun getUser(email:String, password:String, onSuccess:(UserVo) -> Unit, onFailure:(String)  -> Unit)

    fun loginUser(email: String, password: String,
                  onSuccess: (UserVo) -> Unit, onFailure: (String) -> Unit)

    fun getUser():List<UserVo>
}