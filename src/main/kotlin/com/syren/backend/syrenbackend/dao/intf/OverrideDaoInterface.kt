package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideMessageDto
import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideResourceDto

interface OverrideDaoInterface {

    fun createOverrideMessage(overrideMessageDto: OverrideMessageDto): String

    fun createOverrideResource(overrideResourceDto: OverrideResourceDto): String

    fun updateOverrideMessage(id: String, overrideMessageDto: OverrideMessageDto)

    fun updateOverrideResource(id: String, overrideResourceDto: OverrideResourceDto)

    fun deleteOverrideMessage(id: String)

    fun deleteOverrideResource(id: String)

}