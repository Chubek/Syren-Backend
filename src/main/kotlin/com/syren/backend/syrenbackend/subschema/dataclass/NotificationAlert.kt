package com.syren.backend.syrenbackend.subschema.dataclass

import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.OverrideMessageType
import java.util.*

data class NotificationAlert(val id: String = UUID.randomUUID().toString(), val type: OverrideMessageType, val message: String)