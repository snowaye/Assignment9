package com.padc.batch9.assignment9.network.dataagent

import com.padc.batch9.assignment9.data.vo.PlantVo

interface PlantDataAgent {

    fun getPants(onSuccess:(List<PlantVo>) -> Unit, onFailure:(String) -> Unit)
}