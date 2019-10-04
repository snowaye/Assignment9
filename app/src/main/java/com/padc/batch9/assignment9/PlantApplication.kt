package com.padc.batch9.assignment9

import android.app.Application
import android.util.Log
import com.padc.batch9.assignment9.data.model.PlantModelImpl

class PlantApplication:Application() {

    override fun onCreate(){

        Log.i("PlantApplication", "PlantAppCreation")
        PlantModelImpl.initDatabae(applicationContext)
        super.onCreate()
    }
}