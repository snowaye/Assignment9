package com.padc.batch9.assignment9.data.vo

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName

class UploadedUserVo (

    @SerializedName("name")
    @ColumnInfo(name= "name")
    val name:String,

    @SerializedName("user_photo")
    @ColumnInfo(name= "user_photo")
    val userPhoto:String,

    @SerializedName("uploaded_time")
    @ColumnInfo(name= "uploaded_time")
    val uploadedTime:String,

    @SerializedName("user_rank")
    @ColumnInfo(name= "user_rank")
    val rank:String

) {

}