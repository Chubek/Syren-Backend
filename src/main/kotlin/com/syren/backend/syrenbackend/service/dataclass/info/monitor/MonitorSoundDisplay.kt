package com.syren.backend.syrenbackend.service.dataclass.info.monitor

import com.syren.backend.syrenbackend.service.enumclass.MonitorSoundOutput

data class MonitorSoundDisplay(val resolution: MonitorResolution, val soundOutput: MonitorSoundOutput, val volume: Int)