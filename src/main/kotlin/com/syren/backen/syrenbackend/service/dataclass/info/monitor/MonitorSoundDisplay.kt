package com.syren.backen.syrenbackend.service.dataclass.info.monitor

import com.syren.backen.syrenbackend.service.enumclass.MonitorSoundOutput

data class MonitorSoundDisplay(val resolution: MonitorResolution, val soundOutput: MonitorSoundOutput, val volume: Int)