package com.padc.batch9.assignment9

import android.app.Application
import com.padc.batch9.assignment9.data.model.UserModelImpl

class PlantApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        UserModelImpl.initDatabae(applicationContext)
    }
}