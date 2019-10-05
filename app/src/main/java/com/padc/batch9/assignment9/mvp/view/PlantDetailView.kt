package com.padc.batch9.assignment9.mvp.view

import com.padc.batch9.assignment9.data.vo.PlantVo

interface PlantDetailView: BaseView {

    fun displayPlantData(plantVo:PlantVo)

    fun navigaeBack()

    fun displayError(message:String)
}