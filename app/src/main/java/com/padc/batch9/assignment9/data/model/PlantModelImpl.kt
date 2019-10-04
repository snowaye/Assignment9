package com.padc.batch9.assignment9.data.model

import com.padc.batch9.assignment9.data.vo.PlantVo

object PlantModelImpl: BaseModel(), PlantModel {

    override fun getPlants(onSuccess: (List<PlantVo>) -> Unit, onFailure: (String) -> Unit) {
        val plantFromDB = database.plantDao().getAllPlants()
        if (plantFromDB.isNotEmpty()) {
            onSuccess(plantFromDB)
        }
        else {
            plantDataAgent.getPants(
                {
                    database.plantDao().insertPlant(it)
                    onSuccess(it)
                },
                onFailure
            )
        }
        plantDataAgent.getPants(
            onSuccess,
            onFailure
        )
    }

    override fun getPlantByID(id: String): PlantVo {
        return database.plantDao().findPlantById(id)
    }
}