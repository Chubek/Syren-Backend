package com.syren.backend.syrenbackend.subschema.dataclass.records

import java.util.*

data class PlayListRecord(val id: UUID, val playDate: Date, val streamId: String, val successful: Boolean)