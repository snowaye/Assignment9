package com.padc.batch9.assignment9.mvp.presenter

import android.util.Log
import com.padc.batch9.assignment9.data.model.PlantModelImpl
import com.padc.batch9.assignment9.delegate.BackDelegate
import com.padc.batch9.assignment9.mvp.view.PlantDetailView
import com.padc.batch9.assignment9.util.EM_NO_PLANT_FOUND

class PlantDetailPresenter: BasePresenter<PlantDetailView>(), BackDelegate {

    override fun onBackTapEvent() {
        mView.navigaeBack()
    }

    fun onUIReady(plantID:String) {
        if (plantID !=null) {
            val model = PlantModelImpl
            val mPlantVO = model.getPlantByID(plantID)

            if (mPlantVO!=null) {
                Log.i("PantDetal", "mPlantVo{${mPlantVO.plantId}")
                mView.displayPlantData(mPlantVO)
            }
            else mView.displayError(EM_NO_PLANT_FOUND)
        }
    }

}