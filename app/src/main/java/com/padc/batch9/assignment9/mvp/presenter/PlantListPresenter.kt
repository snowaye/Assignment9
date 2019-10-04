package com.padc.batch9.assignment9.mvp.presenter

import com.padc.batch9.assignment9.data.model.PlantModelImpl
import com.padc.batch9.assignment9.delegate.PlantItemDelegate
import com.padc.batch9.assignment9.mvp.view.PlantListView

class PlantListPresenter : BasePresenter<PlantListView>(), PlantItemDelegate{


    override fun onTapItemEvent(id: String) {
        mView.navigateToDetail(id)
    }

    override fun onCreate() {
        var model = PlantModelImpl

        model.getPlants(
            { list -> mView.displayEventList(list)},
            { mView.displayError(it)}
        )
    }


}