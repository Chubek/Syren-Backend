package com.syren.backend.syrenbackend.dao.intf

import java.util.*

interface ScriptResourceServiceInterface<T> {

    fun createScriptResource(scriptResourceDto: T): String

    fun updateScriptResource(id: String, scriptResourceDto: T)

    fun getScriptResource(id: String): Optional<T>

    fun deleteScriptResource(id: String)

}
