package com.padc.batch9.assignment9.mvp.view

import androidx.appcompat.widget.AppCompatImageView
import com.padc.batch9.assignment9.data.vo.PlantVo

interface PlantListView: BaseView {

    fun displayPlantList(plantList:List<PlantVo>)

    fun displayError(errorMessage:String)

    fun navigateToDetail(plantId:String, plantImage:AppCompatImageView)

    fun searchPlant(plantList: List<PlantVo>)

    fun setExistingList(plantList: List<PlantVo>)
}