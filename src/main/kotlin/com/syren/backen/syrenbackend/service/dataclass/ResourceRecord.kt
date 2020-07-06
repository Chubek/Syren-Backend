package com.syren.backen.syrenbackend.service.dataclass

import java.util.*

data class ResourceRecord(val id: UUID, val playlistId: String, val streamId: String, val subStreamId: String)