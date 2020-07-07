package com.syren.backen.syrenbackend.model.list

import com.syren.backen.syrenbackend.service.dataclass.ListItem
import com.syren.backen.syrenbackend.service.dataclass.PlayListRecord
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
class PlayList {
    @Id
    private lateinit var id: String

    private lateinit var items: MutableList<ListItem>

    private lateinit var records: MutableList<PlayListRecord>




}