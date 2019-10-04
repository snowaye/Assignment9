package com.padc.batch9.assignment9.data.model

import com.padc.batch9.assignment9.data.vo.PlantVo

interface PlantModel {

    fun getPlants(onSuccess:(List<PlantVo>) -> Unit, onFailure:(String) -> Unit)

    fun getPlantByID(id:String):PlantVo
}