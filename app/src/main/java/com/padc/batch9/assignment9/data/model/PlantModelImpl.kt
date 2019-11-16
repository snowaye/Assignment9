package com.padc.batch9.assignment9.data.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.padc.batch9.assignment9.data.vo.PlantVo

object PlantModelImpl: BaseModel(), PlantModel {

    override fun findPlanByName(name: String): LiveData<List<PlantVo>> {
        return Transformations.distinctUntilChanged(database.plantDao().findPlantByName(name))
    }

    override fun getPlants(onFailure: (String) -> Unit):LiveData<List<PlantVo>> {
        val plantFromDB = database.plantDao().getAllPlants()

        plantDataAgent.getPants(
            {
                database.plantDao().insertPlant(it)
            },
            onFailure
        )
        return plantFromDB
    }

    override fun getPlantByID(id: String): LiveData<PlantVo> {
        return Transformations.distinctUntilChanged (
            database.plantDao().findPlantById(id)
        )
    }
}