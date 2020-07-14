package com.syren.backend.syrenbackend.subschema.dataclass

import java.util.*

data class ScheduleDate(val id: String = UUID.randomUUID().toString(), val playDate: Date, val stopDate: Date, val playTimes: Int)