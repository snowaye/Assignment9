package com.padc.batch9.assignment9.data.vo

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class TipVo (
    @SerializedName("temperature")
    @ColumnInfo(name = "temperature")
    val temperature:String,

    @SerializedName("light")
    @ColumnInfo(name = "light")
    val light:String,

    @SerializedName("placement")
    @ColumnInfo(name = "placement")
    val placement:String

   ){

}