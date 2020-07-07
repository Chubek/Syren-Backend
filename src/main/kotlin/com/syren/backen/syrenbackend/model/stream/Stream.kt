package com.syren.backen.syrenbackend.model.stream

import com.syren.backen.syrenbackend.service.dataclass.StreamRecord
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
@Document(collection = "stream.stream")
class Stream {
    @Id
    private lateinit var id: String

    private lateinit var scheduleIds: MutableList<String>

    private lateinit var records: MutableList<StreamRecord>
}