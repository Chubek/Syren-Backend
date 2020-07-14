package com.syren.backend.syrenbackend.subschema.dataclass.info

import com.syren.backend.syrenbackend.subschema.dataclass.info.monitor.BasicMonitorInfo
import com.syren.backend.syrenbackend.subschema.dataclass.info.monitor.MonitorLocation
import com.syren.backend.syrenbackend.subschema.dataclass.info.monitor.MonitorNetwork
import com.syren.backend.syrenbackend.subschema.dataclass.info.monitor.MonitorSoundDisplay
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorStatus
import java.util.*

data class MonitorInformation(val id: String = UUID.randomUUID().toString(), var basicMonitorInfo: BasicMonitorInfo, val monitorNetwork: MonitorNetwork,
                              val soundAndDisplay: MonitorSoundDisplay, val location: MonitorLocation, val status: MonitorStatus)