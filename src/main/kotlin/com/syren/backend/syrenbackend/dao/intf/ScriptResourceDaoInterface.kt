package com.syren.backend.syrenbackend.dao.intf

import java.util.*

interface ScriptResourceDaoInterface<T> {

    fun createScriptResource(scriptResourceDto: T): String

    fun updateScriptResource(scriptResourceDto: T)

    fun getScriptResource(id: String): Optional<T>

    fun deleteScriptResource(id: String)

}
