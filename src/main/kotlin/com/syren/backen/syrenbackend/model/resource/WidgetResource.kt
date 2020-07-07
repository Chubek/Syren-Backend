package com.syren.backen.syrenbackend.model.resource

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
@Document(collection = "playlist.playlist")
class WidgetResource {
    @Id
    private lateinit var id: String

    private lateinit var name: String

    private lateinit var javaScriptFileLocation: String
}