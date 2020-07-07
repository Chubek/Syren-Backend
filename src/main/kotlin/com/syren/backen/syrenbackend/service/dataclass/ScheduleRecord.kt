package com.syren.backen.syrenbackend.service.dataclass

import java.util.*

data class ScheduleRecord(val id: UUID, val playDate: Date, val streamId: String, val successful: Boolean)