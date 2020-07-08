package com.syren.backend.syrenbackend.service.dataclass

import com.syren.backend.syrenbackend.service.enumclass.ResourceType
import java.util.*

data class ListItem(val id: UUID, val resourceId: String, val resourceType: ResourceType)