package com.padc.batch9.assignment9.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.padc.batch9.assignment9.data.model.PlantModel
import com.padc.batch9.assignment9.data.model.PlantModelImpl

abstract class BaseFragment:Fragment(){

    protected lateinit var model:PlantModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = PlantModelImpl
    }

}