package com.padc.batch9.assignment9.data.vo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "user")
class UserVo (

    @ColumnInfo(name = "plantId")
    @PrimaryKey
    val id:Int,

    @SerializedName("user_id")
    @ColumnInfo(name="user_id")
    val userId:String,

    @SerializedName("user_name")
    @ColumnInfo(name = "user_name")
    val userName:String,

    @SerializedName("user_photo_url")
    @ColumnInfo(name = "user_photo_url" )
    val photoUrl:String,

    @SerializedName("member_since")
    @ColumnInfo(name = "member_since")
    val memberStartTime:String,

    @SerializedName("member_rank")
    @ColumnInfo(name = "member_rank")
    val memberRant:String
) {

}
