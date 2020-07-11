package com.syren.backend.syrenbackend.dao

interface ScriptResourceServiceInterface<T, R> {

    fun createScriptResource(scriptResourceDto: T): String

    fun updateScriptResource(id: String, scriptResourceDto: T): Void

    fun getScriptResource(id: String): R

    fun deleteScriptResource(id: String): Void

}
