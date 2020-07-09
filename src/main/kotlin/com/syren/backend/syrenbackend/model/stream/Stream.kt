package com.syren.backend.syrenbackend.model.stream

import com.syren.backend.syrenbackend.subschema.dataclass.records.StreamRecord
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
@Document(collection = "stream.stream")
class Stream {
    @Id
    private lateinit var id: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var playlistIds: MutableList<String>

    private lateinit var pathToTemplate: String
}