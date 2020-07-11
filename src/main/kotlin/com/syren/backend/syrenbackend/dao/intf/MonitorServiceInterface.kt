package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.MonitorDto
import java.lang.management.MonitorInfo
import javax.management.monitor.Monitor

interface MonitorServiceInterface {

    fun createMonitor(monitorDto: MonitorDto): String

    fun setCurrentStream(id: String, streamId: String)

    fun setDefaultStream(id: String, defaultStreamId: String)

    fun updateInformation(id: String, monitorInfo: MonitorInfo)

    fun getMonitor(id: String): MonitorDto

    fun deleteMonitor(id: String)


}