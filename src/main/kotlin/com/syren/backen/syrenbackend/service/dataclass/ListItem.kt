package com.syren.backen.syrenbackend.service.dataclass

import com.syren.backen.syrenbackend.service.enumclass.ResourceType
import java.util.*

data class ListItem(val id: UUID, val resourceId: String, val resourceType: ResourceType)