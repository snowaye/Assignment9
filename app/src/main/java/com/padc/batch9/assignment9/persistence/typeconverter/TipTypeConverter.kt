package com.padc.batch9.assignment9.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.padc.batch9.assignment9.data.vo.TipVo

class TipTypeConverter {

    @TypeConverter
    fun toString(list:TipVo):String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(jsonString:String):TipVo{
        val typeToken = object :TypeToken<TipVo>() {

        }.type
        return Gson().fromJson(jsonString, typeToken)
    }
}