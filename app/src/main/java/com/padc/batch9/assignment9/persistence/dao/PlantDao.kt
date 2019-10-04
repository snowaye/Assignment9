package com.padc.batch9.assignment9.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padc.batch9.assignment9.data.vo.PlantVo

@Dao
abstract class PlantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertPlant(list:List<PlantVo>):LongArray

    @Query("SELECT * FROM plant")
    abstract fun getAllPlants():List<PlantVo>

    @Query("SELECT * FROM plant WHERE plant_id=:id ")
    abstract fun findPlantById(id:String):PlantVo

    fun areEventsExistInDB(): Boolean{
        return getAllPlants().isNotEmpty()
    }
}