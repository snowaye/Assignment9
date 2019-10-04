package com.padc.batch9.assignment9.mvp.view

import com.padc.batch9.assignment9.data.vo.PlantVo

interface PlantListView: BaseView {

    fun displayEventList(plantList:List<PlantVo>)

    fun displayError(errorMessage:String)

    fun navigateToDetail(plantId:String)
}