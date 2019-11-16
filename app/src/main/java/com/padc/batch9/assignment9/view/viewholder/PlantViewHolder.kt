package com.padc.batch9.assignment9.view.viewholder

import android.view.View
import coil.api.load
import coil.transform.CircleCropTransformation
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.delegate.PlantItemDelegate
import kotlinx.android.synthetic.main.listitem_plant.view.*

class PlantViewHolder(itemView: View,
                      private val delegate: PlantItemDelegate):BaseViewHolder<PlantVo>(itemView) {

    init {
        itemView.setOnClickListener {
            val id = data?.plantId
            data?.plantId?.let { id->
                delegate.onTapItemEvent(id, itemView.imgv_plant)
            }
        }
    }

    override fun bindData(data: PlantVo) {
        itemView.tvPlantName.text = data.plantName
        itemView.tvUploadedBy.text = data.uploadedUser.name
        itemView.imgv_post_by.load(data.uploadedUser.userPhoto) {
            crossfade(true)
            crossfade(500)
            transformations(CircleCropTransformation())
            error(R.drawable.ic_avatar)
            placeholder(R.drawable.ic_avatar)
        }
        itemView.imgv_plant.load(data.phantPhoto) {
            crossfade(true)
            crossfade(500)
            error(R.drawable.ic_plant)
            placeholder(R.drawable.ic_plant)
        }

    }
}