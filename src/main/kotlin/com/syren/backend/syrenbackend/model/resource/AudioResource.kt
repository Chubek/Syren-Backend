package com.syren.backend.syrenbackend.model.resource

import com.syren.backend.syrenbackend.service.dataclass.info.FileInfo
import com.syren.backend.syrenbackend.service.dataclass.records.ResourceRecord
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "resource.audio")
class AudioResource {
    @Id
    private lateinit var id: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var record: MutableList<ResourceRecord>

    private lateinit var fileInfo: FileInfo

    private lateinit var metadata: Metadata
}