package com.syren.backend.syrenbackend.dao.intf


interface MediaResourceServiceInterface<T, R> {

    fun createResource(resourceDto: T): String

    fun updateResource(resourceDto: T): Void

    fun deleteResource(resourceDto: T): Void

    fun getResource(id: String): R

}
