package com.syren.backend.syrenbackend.model.display

import com.syren.backend.syrenbackend.subschema.dataclass.info.MonitorInformation
import com.syren.backend.syrenbackend.subschema.dataclass.records.MonitorRecord
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
@Document(collection = "display.monitor")
class Monitor {
    @Id
    private lateinit var id: String

    private lateinit var currentStreamId: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var formerStreams: MutableList<MonitorRecord>

    private lateinit var defaultStreamId: String

    private lateinit var accessPhrase: String

    private lateinit var information: MonitorInformation
}