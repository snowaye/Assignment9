package com.padc.batch9.assignment9.data.model

import com.padc.batch9.assignment9.data.vo.UserVo

object UserModelImpl: BaseModel(), UserModel {


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
}