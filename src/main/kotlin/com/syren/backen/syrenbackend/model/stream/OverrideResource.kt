package com.syren.backen.syrenbackend.model.stream

import com.syren.backen.syrenbackend.service.dataclass.records.OverrideRecord
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "stream.override.resource")
class OverrideResource {
    @Id
    private lateinit var id: UUID

    private lateinit var resourceId: String

    private lateinit var records: MutableList<OverrideRecord>
}