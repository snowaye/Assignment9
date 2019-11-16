package com.padc.batch9.assignment9.data.model

import androidx.lifecycle.LiveData
import com.padc.batch9.assignment9.data.vo.PlantVo

interface PlantModel {

    fun getPlants(onFailure:(String) -> Unit):LiveData<List<PlantVo>>

    fun getPlantByID(id:String):LiveData<PlantVo>

    fun findPlanByName(id:String):LiveData<List<PlantVo>>
}