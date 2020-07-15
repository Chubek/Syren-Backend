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
import java.util.*


@Accessors(chain = true)
@Document(collection = "display.monitor")
data class Monitor(@Id val id: String = UUID.randomUUID().toString(), var currentStreamId: String = "",
                   @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)  val formerStreams: MutableList<MonitorRecord>,
                   var defaultStreamId: String = "",
                   var accessPhrase: String,
                   val information: MonitorInformation
)