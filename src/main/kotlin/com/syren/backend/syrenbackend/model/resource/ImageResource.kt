package com.syren.backend.syrenbackend.model.resource

import com.syren.backend.syrenbackend.subschema.dataclass.info.FileInfo
import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Accessors(chain = true)
@Document(collection = "resource.image")
data class ImageResource(@Id val id: String = UUID.randomUUID().toString(),
                         @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true) val fileInfo: FileInfo,
                         val metadata: Metadata)