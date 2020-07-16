package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideMessageDto
import java.util.*

interface OverrideMessageDaoInterface {
    fun createOverrideMessage(overrideMessageDto: OverrideMessageDto): String

    fun updateOverrideMessage(overrideMessageDto: OverrideMessageDto)

    fun getOverrideMessage(id: String): Optional<OverrideMessageDto>

    fun deleteOverrideMessage(id: String)
}