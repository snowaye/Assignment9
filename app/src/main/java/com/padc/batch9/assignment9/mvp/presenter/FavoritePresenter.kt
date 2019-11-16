package com.padc.batch9.assignment9.mvp.presenter

import androidx.lifecycle.Observer
import com.padc.batch9.assignment9.activity.BaseActivity
import com.padc.batch9.assignment9.data.model.PlantModelImpl
import com.padc.batch9.assignment9.delegate.FavoriteItemDelegate
import com.padc.batch9.assignment9.mvp.view.FavoriteView

class FavoritePresenter: BasePresenter<FavoriteView>(), FavoriteItemDelegate{

    override fun onTapFavouriteButton(id: String) {

    }

    fun onUIReady(activity:BaseActivity) {
        var model = PlantModelImpl

        model.getPlants(
            { mView.showError(it)}
        ).observe(activity, Observer { mView.displayFavoriteList(it) })
    }
}