package com.syren.backend.syrenbackend.model.stream

import com.syren.backend.syrenbackend.subschema.dataclass.info.TemplateInfo
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
@Document(collection = "stream.layout.template")
class StreamLayoutTemplate {
    @Id
    private lateinit var id: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var templateInfo: TemplateInfo

    private lateinit var fileLocation: String
}