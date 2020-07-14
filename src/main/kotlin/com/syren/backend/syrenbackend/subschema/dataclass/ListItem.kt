package com.syren.backend.syrenbackend.subschema.dataclass

import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.ResourceType
import java.util.*

data class ListItem(val id: String = UUID.randomUUID().toString(), val resourceId: String, val resourceType: ResourceType)