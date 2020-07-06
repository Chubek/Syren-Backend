package com.syren.backen.syrenbackend.model.resource

import com.syren.backen.syrenbackend.service.dataclass.FileInfo
import com.syren.backen.syrenbackend.service.dataclass.ResourceRecord
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
@Document(collection = "resource.image")
class ImageResource {
    @Id
    private lateinit var id: String

    private lateinit var record: MutableList<ResourceRecord>

    private lateinit var fileInfo: FileInfo

    private lateinit var metadata: Metadata


}