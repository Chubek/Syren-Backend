package com.syren.backen.syrenbackend.model.display

import com.syren.backen.syrenbackend.service.dataclass.MonitorRecord
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
@Document(collection = "display.monitor")
class Monitor {
    @Id
    private lateinit var id: String

    private lateinit var currentStreamId: String

    private lateinit var formerStreams: MutableList<MonitorRecord>
}