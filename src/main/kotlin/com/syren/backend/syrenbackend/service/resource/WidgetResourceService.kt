package com.syren.backend.syrenbackend.service.resource

import com.syren.backend.syrenbackend.dao.impl.WidgetResourceDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.resource.WidgetResource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service


@Service
@ComponentScan
class WidgetResourceService {

    @Autowired
    private lateinit var widgetResourceDao: WidgetResourceDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createWidgetResource(javaScriptLocation: String, name: String): String {

        val widgetResource = WidgetResource(javaScriptFileLocation =  javaScriptLocation, name = name)

        return widgetResourceDao.createScriptResource(dtoMappers.widgetResourceMapperDto(widgetResource))
    }

    fun updateWidgetResourceLocation(id: String, javaScriptLocation: String) {

        val widgetResourceDto = widgetResourceDao.getScriptResource(id)

        var widgetResource = dtoMappers.widgetResourceMapperEntity(widgetResourceDto.get())

        widgetResource.javaScriptFileLocation = javaScriptLocation

        widgetResourceDao.updateScriptResource(dtoMappers.widgetResourceMapperDto(widgetResource))
    }

    fun updateWidgetResourceName(id: String, name: String) {

        val widgetResourceDto = widgetResourceDao.getScriptResource(id)

        var widgetResource = dtoMappers.widgetResourceMapperEntity(widgetResourceDto.get())

        widgetResource.name = name

        widgetResourceDao.updateScriptResource(dtoMappers.widgetResourceMapperDto(widgetResource))
    }

    fun deleteWidgetResource(id: String) {
        widgetResourceDao.deleteScriptResource(id)
    }

}