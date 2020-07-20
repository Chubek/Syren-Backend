package com.syren.backend.syrenbackend.service.stream

import com.syren.backend.syrenbackend.dao.impl.OverrideMessageDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.stream.OverrideMessage
import com.syren.backend.syrenbackend.subschema.dataclass.NotificationAlert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service


@Service
@ComponentScan
class OverrideMessageService {

    @Autowired
    private lateinit var overrideMessageDao: OverrideMessageDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createOverrideMessage(notificationAlert: NotificationAlert): String {

        val overrideMessage = OverrideMessage(notificationAlert = notificationAlert)

        return overrideMessageDao.createOverrideMessage(dtoMappers.overrideMessageMapperDto(overrideMessage))
    }

    fun updateOverrideMessage(id: String, notificationAlert: NotificationAlert) {

        val overrideMessageDto = overrideMessageDao.getOverrideMessage(id)

        var overrideMessage = dtoMappers.overrideMessageMapperEntity(overrideMessageDto.get())

        overrideMessage.notificationAlert = notificationAlert

        overrideMessageDao.updateOverrideMessage(dtoMappers.overrideMessageMapperDto(overrideMessage))
    }

    fun deleteOverrideMessage(id: String) {

        overrideMessageDao.deleteOverrideMessage(id)
    }

    fun getOverrideMessage(id: String): OverrideMessage {

        return dtoMappers.overrideMessageMapperEntity(overrideMessageDao.getOverrideMessage(id).get())
    }

}
