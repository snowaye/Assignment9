package com.padc.batch9.assignment9.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padc.batch9.assignment9.persistence.dao.UserDao
import com.padc.batch9.assignment9.util.PLANT_DB

@Database(entities = arrayOf(UserDao::class), version = 1, exportSchema = false)
abstract class PlantDatabase : RoomDatabase(){
    abstract fun userDao():UserDao

    companion object {
        private var instance: PlantDatabase?=null

        fun getDatabase(context:Context):PlantDatabase {
           if (instance==null) {
               instance = Room.databaseBuilder(context, PlantDatabase::class.java, PLANT_DB)
                   .allowMainThreadQueries()
                   .fallbackToDestructiveMigration().build()
           }
            val db = instance!!
            return db
        }
    }
}