package com.padc.batch9.assignment9.mvp.presenter


import com.padc.batch9.assignment9.data.model.PlantModelImpl
import com.padc.batch9.assignment9.delegate.BackDelegate
import com.padc.batch9.assignment9.mvp.view.PlantDetailView

class PlantDetailPresenter: BasePresenter<PlantDetailView>(), BackDelegate {

    override fun onBackTapEvent() {
        mView.navigaeBack()
    }

    fun onUIReady(plantID:String) {
        if (plantID !=null) {
            val model = PlantModelImpl
            val mPlantVO = model.getPlantByID(plantID)
                .observeForever {
                    mView.displayPlantData(it)
                }
        }
    }

}