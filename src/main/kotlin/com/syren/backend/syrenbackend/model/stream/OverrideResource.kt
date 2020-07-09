package com.syren.backend.syrenbackend.model.stream

import com.syren.backend.syrenbackend.subschema.dataclass.records.OverrideRecord
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
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

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var resourceId: String

}