package com.padc.batch9.assignment9.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.data.model.UserModel
import com.padc.batch9.assignment9.data.model.UserModelImpl
import kotlinx.android.synthetic.main.activity_plant_detail.*

abstract class BaseActivity : AppCompatActivity() {

    protected lateinit var userModel:UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userModel = UserModelImpl
    }

    protected fun showIdefiniteSnakBar(message: String) {
        val snackbar = Snackbar.make(
            window.decorView, message,
            Snackbar.LENGTH_INDEFINITE
        )
        snackbar.setAction(
            getString(R.string.label_okay)
        ) { snackbar.dismiss() }
    }
}
