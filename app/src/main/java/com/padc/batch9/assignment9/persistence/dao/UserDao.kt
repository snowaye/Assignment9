package com.padc.batch9.assignment9.persistence.dao

import androidx.room.*
import com.padc.batch9.assignment9.data.vo.UserVo

@Dao
abstract class UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertUser(user:UserVo):Long

    @Query("SELECT * FROM user WHERE  user_id = :id ")
    abstract fun getUser(id:String): UserVo

    @Query("SELECT * FROM user")
    abstract fun getAllUser():List<UserVo>
}