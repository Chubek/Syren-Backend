package com.syren.backen.syrenbackend.model.resource

import com.syren.backen.syrenbackend.service.dataclass.info.FileInfo
import com.syren.backen.syrenbackend.service.dataclass.records.ResourceRecord
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "resource.video")
class VideoResource {
    @Id
    private lateinit var id: String

    private lateinit var record: MutableList<ResourceRecord>

    private lateinit var fileInfo: FileInfo

    private lateinit var metadata: Metadata

}