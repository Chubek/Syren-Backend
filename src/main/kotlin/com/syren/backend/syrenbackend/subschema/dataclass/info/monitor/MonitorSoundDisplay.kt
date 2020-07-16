package com.syren.backend.syrenbackend.subschema.dataclass.info.monitor

import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorSoundOutput

data class MonitorSoundDisplay(val resolution: MonitorResolution, val soundOutput: MonitorSoundOutput, val volume: Int)