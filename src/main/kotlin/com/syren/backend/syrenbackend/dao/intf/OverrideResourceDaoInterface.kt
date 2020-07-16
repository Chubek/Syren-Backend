package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideResourceDto
import java.util.*

interface OverrideResourceDaoInterface {

    fun createOverrideResource(overrideResourceDto: OverrideResourceDto): String

    fun updateOverrideResource(overrideResourceDto: OverrideResourceDto)

    fun getOverrideResource(id: String): Optional<OverrideResourceDto>

    fun deleteOverrideResource(id: String)


}