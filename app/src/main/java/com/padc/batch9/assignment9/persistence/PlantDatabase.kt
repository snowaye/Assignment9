package com.padc.batch9.assignment9.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.data.vo.UserVo
import com.padc.batch9.assignment9.persistence.dao.PlantDao
import com.padc.batch9.assignment9.persistence.dao.UserDao
import com.padc.batch9.assignment9.persistence.typeconverter.StringTypeConverter
import com.padc.batch9.assignment9.persistence.typeconverter.TipTypeConverter
import com.padc.batch9.assignment9.persistence.typeconverter.UploadedUserTypeConverter
import com.padc.batch9.assignment9.util.PLANT_DB

@Database(entities = arrayOf(UserVo::class, PlantVo::class), version = 9, exportSchema = false)
@TypeConverters(TipTypeConverter::class, UploadedUserTypeConverter::class, StringTypeConverter::class)
abstract class PlantDatabase : RoomDatabase(){
    abstract fun userDao():UserDao

    abstract fun plantDao():PlantDao

    companion object{
        private var instance : PlantDatabase?= null

        fun getInstance(context: Context):PlantDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context, PlantDatabase::class.java, PLANT_DB)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            val db = instance!!
            return db
        }
    }
}