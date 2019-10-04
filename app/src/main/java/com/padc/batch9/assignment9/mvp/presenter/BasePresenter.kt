package com.padc.batch9.assignment9.mvp.presenter

import com.padc.batch9.assignment9.mvp.view.BaseView


abstract class BasePresenter<T: BaseView> {
    protected lateinit var mView:T

    open fun initPresenter(view:T) {
        this.mView = view
    }

    open fun onStart() {}

    open fun onCreate() {}

    open fun onPause() {}

    open fun onStop() {}

    open fun onDestroy() {}

    open fun onResume() {}

}