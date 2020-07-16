package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.MonitorDto
import java.util.*

interface MonitorDaoInterface {

    fun createMonitor(monitorDto: MonitorDto): String

    fun updateMonitor(monitorDto: MonitorDto)

    fun findByCurrentStreamId(currentStreamId: String): MonitorDto

    fun findByDefaultStreamId(defaultStreamId: String): MonitorDto

    fun findByAccessPhrase(accessPhrase: String): MonitorDto

    fun getMonitor(id: String): Optional<MonitorDto>

    fun deleteMonitor(id: String)


}