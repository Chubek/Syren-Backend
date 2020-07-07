package com.syren.backen.syrenbackend.service.dataclass

import java.util.*

data class ScheduleDate(val id: UUID, val playDate: Date, val stopDate: Date, val playTimes: Int)