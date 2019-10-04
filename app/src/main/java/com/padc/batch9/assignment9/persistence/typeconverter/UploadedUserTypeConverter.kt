package com.padc.batch9.assignment9.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.padc.batch9.assignment9.data.vo.UploadedUserVo

class UploadedUserTypeConverter {
    @TypeConverter
    fun toString(userVo:UploadedUserVo):String {
        return Gson().toJson(userVo)
    }

    @TypeConverter
    fun toUploadedUser(jsonString:String):UploadedUserVo {
        return  Gson().fromJson(jsonString, UploadedUserVo::class.java)
    }
}