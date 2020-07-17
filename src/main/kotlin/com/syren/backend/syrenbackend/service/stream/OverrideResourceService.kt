package com.syren.backend.syrenbackend.service.stream

import com.syren.backend.syrenbackend.dao.impl.OverrideResourceDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.stream.OverrideResource
import org.springframework.beans.factory.annotation.Autowired

class OverrideResourceService {

    @Autowired
    private lateinit var overrideResourceDao: OverrideResourceDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createOverrideResource(resourceId: String): String {

        val overrideResource = OverrideResource(resourceId = resourceId)

        return overrideResourceDao.createOverrideResource(dtoMappers.overrideResourceMapperDto(overrideResource))
    }

    fun updateOverrideResource(id: String, resourceId: String) {

        val overrideResourceDto = overrideResourceDao.getOverrideResource(id)

        var overrideResource = dtoMappers.overrideResourceMapperEntity(overrideResourceDto.get())

        overrideResource.resourceId = resourceId

        overrideResourceDao.updateOverrideResource(dtoMappers.overrideResourceMapperDto(overrideResource))
    }

    fun deleteOverrideResource(id: String) {

        overrideResourceDao.deleteOverrideResource(id)
    }

}
