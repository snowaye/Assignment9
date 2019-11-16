package com.padc.batch9.assignment9.mvp.view

interface LoginView: BaseView {
    fun showProgressBar()
    fun hideProgressBar()
    fun showEmailEmptyError()
    fun showPasswordEmptyError()
    fun navigateToHome()
    fun doLogin(email:String, password:String)

}