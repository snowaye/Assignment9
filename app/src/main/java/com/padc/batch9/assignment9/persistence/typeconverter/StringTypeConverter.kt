package com.padc.batch9.assignment9.persistence.typeconverter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StringTypeConverter {

    @TypeConverter
    fun toString(list:List<String>):String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(jsonString:String):List<String> {
        val typeToken = object :TypeToken<List<String>>() {}.type
        return Gson().fromJson(jsonString, typeToken)
    }
}
