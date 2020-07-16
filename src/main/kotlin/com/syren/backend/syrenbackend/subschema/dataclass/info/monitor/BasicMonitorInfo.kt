package com.syren.backend.syrenbackend.subschema.dataclass.info.monitor

import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorOrientation

data class BasicMonitorInfo(val tags: MutableList<String>, val monitorOrientation: MonitorOrientation)