package com.syren.backend.syrenbackend.service.dataclass.info

import com.syren.backend.syrenbackend.service.dataclass.info.monitor.BasicMonitorInfo
import com.syren.backend.syrenbackend.service.dataclass.info.monitor.MonitorLocation
import com.syren.backend.syrenbackend.service.dataclass.info.monitor.MonitorNetwork
import com.syren.backend.syrenbackend.service.dataclass.info.monitor.MonitorSoundDisplay
import com.syren.backend.syrenbackend.service.enumclass.MonitorStatus
import java.util.*

data class MonitorInformation(val id: UUID, val basicMonitorInfo: BasicMonitorInfo, val monitorNetwork: MonitorNetwork,
                              val soundAndDisplay: MonitorSoundDisplay, val location: MonitorLocation, val status: MonitorStatus)