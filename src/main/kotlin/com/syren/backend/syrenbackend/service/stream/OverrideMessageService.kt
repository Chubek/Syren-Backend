package com.syren.backend.syrenbackend.service.stream

import com.beust.klaxon.Klaxon
import com.syren.backend.syrenbackend.dao.impl.OverrideMessageDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.stream.OverrideMessage
import com.syren.backend.syrenbackend.subschema.dataclass.NotificationAlert
import org.springframework.beans.factory.annotation.Autowired

class OverrideMessageService {

    @Autowired
    private lateinit var overrideMessageDao: OverrideMessageDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createOverrideMessage(notificationJson: String): String {
        val notification = Klaxon().parse<NotificationAlert>(notificationJson)

        val overrideMessage = OverrideMessage(notificationAlert = notification!!)

        return overrideMessageDao.createOverrideMessage(dtoMappers.overrideMessageMapperDto(overrideMessage))
    }

    fun updateOverrideMessage(id: String, notificationJson: String) {

        val overrideMessageDto = overrideMessageDao.getOverrideMessage(id)

        var overrideMessage = dtoMappers.overrideMessageMapperEntity(overrideMessageDto.get())

        overrideMessage.notificationAlert = Klaxon().parse<NotificationAlert>(notificationJson)!!

        overrideMessageDao.updateOverrideMessage(dtoMappers.overrideMessageMapperDto(overrideMessage))
    }

    fun deleteOverrideMessage(id: String) {

        overrideMessageDao.deleteOverrideMessage(id)
    }

}
