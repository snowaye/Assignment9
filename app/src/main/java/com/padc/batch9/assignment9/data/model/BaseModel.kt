package com.padc.batch9.assignment9.data.model

import android.content.Context
import com.padc.batch9.assignment9.network.dataagent.UserDataAgent
import com.padc.batch9.assignment9.network.dataagent.UserDataAgentImpl
import com.padc.batch9.assignment9.persistence.PlantDatabase

abstract class BaseModel {
    protected val dataAgent: UserDataAgent = UserDataAgentImpl

    protected lateinit var database: PlantDatabase

    fun initDatabae(context: Context) {
        database= PlantDatabase.getDatabase(context)
    }
}