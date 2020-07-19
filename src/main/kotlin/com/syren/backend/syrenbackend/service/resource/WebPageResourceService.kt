package com.syren.backend.syrenbackend.service.resource

import com.syren.backend.syrenbackend.dao.impl.WebPageResourceDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.resource.WebPageResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
@ComponentScan
class WebPageResourceService {

    @Autowired
    private lateinit var webPageResourceDao: WebPageResourceDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createWebPageResource(htmlLocation: String): String {

        val webPageResource = WebPageResource(htmlFilePath = htmlLocation)

        return webPageResourceDao.createScriptResource(dtoMappers.webPageResourceMapperDto(webPageResource))
    }

    fun updateWebPageResource(id: String, htmlLocation: String) {

        val webPageResourceDto = webPageResourceDao.getScriptResource(id)

        var webPageResource = dtoMappers.webPageResourceMapperEntity(webPageResourceDto.get())

        webPageResource.htmlFilePath = htmlLocation

        webPageResourceDao.updateScriptResource(dtoMappers.webPageResourceMapperDto(webPageResource))
    }

    fun getWebPageResource(id: String): WebPageResource {

        return dtoMappers.webPageResourceMapperEntity(webPageResourceDao.getScriptResource(id).get())

    }

    fun deleteWebPageResource(id: String) {
        webPageResourceDao.deleteScriptResource(id)
    }

}