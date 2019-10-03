package com.padc.batch9.assignment9.mvp.presenter

interface LoginPresenter {

    fun clear()

    fun doLogin(email:String, password:String)

    fun setProgressBarVisibility(visibility:Int)
}