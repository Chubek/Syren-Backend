package com.syren.backend.syrenbackend.service.dataclass.records

import java.util.*

data class ResourceRecord(val id: UUID, val playlistId: String, val streamId: String, val subStreamId: String)