package com.syren.backen.syrenbackend.service.dataclass

import com.syren.backen.syrenbackend.service.enumclass.OverrideMessageType
import java.util.*

data class NotificationAlert(val id: UUID, val type: OverrideMessageType, val message: String)