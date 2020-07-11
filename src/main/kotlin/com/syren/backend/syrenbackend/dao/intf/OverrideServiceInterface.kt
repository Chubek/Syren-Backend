package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideMessageDto
import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideResourceDto

interface OverrideServiceInterface {

    fun createOverrideMessage(overrideMessageDto: OverrideMessageDto): String

    fun createOverrideResource(overrideResourceDto: OverrideResourceDto): String

    fun updateOverrideMessage(id: String, overrideMessageDto: OverrideMessageDto): Void

    fun updateOverrideResource(id: String, overrideResourceDto: OverrideResourceDto): Void

    fun deleteOverrideMessage(id: String): Void

    fun deleteOverrideResource(id: String): Void

}