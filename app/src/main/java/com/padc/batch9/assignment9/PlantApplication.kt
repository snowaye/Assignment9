package com.padc.batch9.assignment9

import android.app.Application
import android.util.Log
import com.padc.batch9.assignment9.data.model.PlantModelImpl
import com.padc.batch9.assignment9.data.model.UserModelImpl

class PlantApplication:Application() {

    override fun onCreate(){

        Log.i("PlantApplication", "PlantAppCreation")
        UserModelImpl.initDatabae(applicationContext)
        PlantModelImpl.initDatabae(applicationContext)
        super.onCreate()
    }
}