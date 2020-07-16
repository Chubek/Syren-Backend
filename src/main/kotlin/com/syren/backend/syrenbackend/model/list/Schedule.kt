package com.syren.backend.syrenbackend.model.list

import com.syren.backend.syrenbackend.subschema.dataclass.ScheduleDate
import lombok.experimental.Accessors
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.IndexDirection
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*


@Accessors(chain = true)
@Document(collection = "playlist.schedule")
data class Schedule(@Id val id: String = UUID.randomUUID().toString(),
                    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true) var streamId: String,
                    val playDates: MutableList<ScheduleDate>)