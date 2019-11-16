package com.padc.batch9.assignment9.delegate

import androidx.appcompat.widget.AppCompatImageView

interface PlantItemDelegate {
    fun onTapItemEvent(id:String, plantImage:AppCompatImageView)
}