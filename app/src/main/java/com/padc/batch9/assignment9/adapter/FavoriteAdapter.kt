package com.padc.batch9.assignment9.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padc.batch9.assignment9.R
import com.padc.batch9.assignment9.data.vo.PlantVo
import com.padc.batch9.assignment9.delegate.FavoriteItemDelegate
import com.padc.batch9.assignment9.view.viewholder.FavoriteViewHolder

class FavoriteAdapter(private val favoriteItemDelegate: FavoriteItemDelegate):BaseAdapter<FavoriteViewHolder, PlantVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem_favorite, parent, false);
        return FavoriteViewHolder(view, favoriteItemDelegate)
    }
}