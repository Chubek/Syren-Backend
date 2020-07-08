package com.syren.backend.syrenbackend.model.list

import com.syren.backend.syrenbackend.service.dataclass.ScheduleDate
import com.syren.backend.syrenbackend.service.dataclass.records.ScheduleRecord
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
@Document(collection = "playlist.schedule")
abstract class Schedule {
    @Id
    private lateinit var id: String

    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
    private lateinit var playListId: String

    private lateinit var playDates: MutableList<ScheduleDate>

    private lateinit var scheduleRecords: MutableList<ScheduleRecord>


}