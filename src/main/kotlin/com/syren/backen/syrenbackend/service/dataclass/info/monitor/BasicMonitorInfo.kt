package com.syren.backen.syrenbackend.service.dataclass.info.monitor

import com.syren.backen.syrenbackend.service.enumclass.MonitorOrientation

data class BasicMonitorInfo(val tags: MutableList<String>, val monitorOrientation: MonitorOrientation)