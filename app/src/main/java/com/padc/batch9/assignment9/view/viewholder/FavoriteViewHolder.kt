package com.padc.batch9.assignment9.view.viewholder

import android.view.View
import coil.api.load
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.delegate.FavoriteItemDelegate
import kotlinx.android.synthetic.main.listitem_favorite.view.*

class FavoriteViewHolder(itemView: View, favoriteItemDelegate: FavoriteItemDelegate):BaseViewHolder<PlantVo>(itemView) {

    init {
        itemView.setOnClickListener {
            var id = data?.plantId
            id?.let {
                favoriteItemDelegate.onTapFavouriteButton(it)
            }
        }
    }

    override fun bindData(data: PlantVo) {
        itemView.imgv_favorite.load(data.phantPhoto) {
            crossfade(2000)
            crossfade(true)
        }
    }
}