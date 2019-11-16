package com.padc.batch9.assignment9.mvp.presenter

import androidx.appcompat.widget.AppCompatImageView
import androidx.lifecycle.Observer
import com.padc.batch9.assignment9.activity.BaseActivity
import com.padc.batch9.assignment9.data.model.PlantModelImpl
import com.padc.batch9.assignment9.delegate.PlantItemDelegate
import com.padc.batch9.assignment9.mvp.view.PlantListView

class PlantListPresenter : BasePresenter<PlantListView>(), PlantItemDelegate{


    override fun onTapItemEvent(id: String, plantImageView: AppCompatImageView) {
        mView.navigateToDetail(id, plantImageView)
    }

    fun onEditTextTextChange (search:String) {
        var model = PlantModelImpl
        model.findPlanByName(search)
            .observeForever({mView.searchPlant(it)})
    }

    fun onEditTexyEmpty() {
        val model = PlantModelImpl
        model.getPlants(
            { mView.displayError(it)}
        ).observeForever( { mView.setExistingList(it) })
    }

    fun onUIReady(activity: BaseActivity) {
        var model = PlantModelImpl

        model.getPlants(
            { mView.displayError(it)}
        ).observe(activity, Observer { mView.displayPlantList(it) })
    }
}