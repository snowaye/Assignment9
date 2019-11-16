package com.padc.batch9.assignment9.persistence.dao

import androidx.lifecycle.LiveData
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
    abstract fun getAllPlants():LiveData<List<PlantVo>>

    @Query("SELECT * FROM plant WHERE plant_id LIKE '%' || :id || '%'")
    abstract fun findPlantById(id:String):LiveData<PlantVo>

    @Query("SELECT * FROM plant WHERE plant_name LIKE :name")
    abstract fun findPlantByName(name:String):LiveData<List<PlantVo>>

}