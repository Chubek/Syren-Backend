package com.syren.backend.syrenbackend.service.dataclass.info.monitor

import com.syren.backend.syrenbackend.service.enumclass.MonitorOrientation

data class BasicMonitorInfo(val tags: MutableList<String>, val monitorOrientation: MonitorOrientation)