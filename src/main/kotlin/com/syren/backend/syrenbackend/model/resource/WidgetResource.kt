package com.syren.backend.syrenbackend.model.resource

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
@Document(collection = "playlist.playlist")
class WidgetResource {
    @Id
    private lateinit var id: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var name: String

    private lateinit var javaScriptFileLocation: String
}