package com.padc.batch9.assignment9.data.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "plant")
class PlantVo (
    @SerializedName("plant_id")
    @ColumnInfo(name = "plant_id")
    val plantId:String,

    @PrimaryKey
    val id:Int,

    @SerializedName("plant_name")
    @ColumnInfo(name = "plant_name")
    val plantName:String,


    @SerializedName("plant_type")
    val plantType:List<String>,


    @SerializedName("description")
    @ColumnInfo(name = "description")
    val description:String,

    @SerializedName("top_tip")
    @ColumnInfo(name = "top_tip")
    val topTip:String,

    @SerializedName("tips")
    val tips:TipVo,

    @SerializedName("uploaded_user")
    val uploadedUser: UploadedUserVo,

    @SerializedName("plant_photo")
    @ColumnInfo(name = "plant_photo")
    val phantPhoto:String

) {
}