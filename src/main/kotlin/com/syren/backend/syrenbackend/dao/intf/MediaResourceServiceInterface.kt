package com.syren.backend.syrenbackend.dao.intf

import java.util.*


interface MediaResourceServiceInterface<T> {

    fun createResource(resourceDto: T): String

    fun updateResource(resourceDto: T)

    fun deleteResource(id: String)

    fun getResource(id: String): Optional<T>

}
