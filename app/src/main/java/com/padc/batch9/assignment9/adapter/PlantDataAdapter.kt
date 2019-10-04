package com.padc.batch9.assignment9.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.delegate.PlantItemDelegate
import com.padc.batch9.assignment9.view.viewholder.PlantViewHolder

class PlantDataAdapter(private val mPlantItemDelegate: PlantItemDelegate):BaseAdapter<PlantViewHolder, PlantVo> (){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).
            inflate(R.layout.listitem_plant, parent, false)
        return PlantViewHolder(itemView, mPlantItemDelegate)
    }
}