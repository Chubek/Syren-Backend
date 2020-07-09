package com.syren.backend.syrenbackend.model.list

import com.syren.backend.syrenbackend.subschema.dataclass.ListItem
import com.syren.backend.syrenbackend.subschema.dataclass.records.PlayListRecord
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
class PlayList {
    @Id
    private lateinit var id: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var items: MutableList<ListItem>

}