package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.MonitorDto
import java.lang.management.MonitorInfo
import javax.management.monitor.Monitor

interface MonitorServiceInterface {

    fun createMonitor(monitorDto: MonitorDto): String

    fun setCurrentStream(id: String, streamId: String): Void

    fun setDefaultStream(id: String, defaultStreamId: String): Void

    fun updateInformation(id: String, monitorInfo: MonitorInfo): Void

    fun getMonitor(id: String): Monitor

    fun deleteMonitor(id: String): Void


}