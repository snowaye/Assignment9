package com.padc.batch9.assignment9.mvp.view

import com.padc.batch9.assignment9.data.vo.PlantVo

interface FavoriteView: BaseView {

    fun displayFavoriteList(list:List<PlantVo>)

    fun showError(errorMessage:String)

    fun changeFavoriteIcon()
}