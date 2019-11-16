package com.padc.batch9.assignment9.mvp.presenter
import com.padc.batch9.assignment9.mvp.view.LoginView

class LoginPresenter: BasePresenter<LoginView>() {


    fun onTapLoginButton(email:String, password:String) {
        when {
            email.isEmpty() -> mView.showEmailEmptyError()
            password.isEmpty() -> mView.showPasswordEmptyError()
            else -> mView.doLogin(email, password)
        }
    }
}