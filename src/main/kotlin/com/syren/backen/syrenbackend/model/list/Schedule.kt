package com.syren.backen.syrenbackend.model.list

import com.syren.backen.syrenbackend.service.dataclass.ScheduleDate
import com.syren.backen.syrenbackend.service.dataclass.ScheduleRecord
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
@Document(collection = "playlist.schedule")
abstract class Schedule {
    @Id
    private lateinit var id: String

    private lateinit var playListId: String

    private lateinit var playDates: MutableList<ScheduleDate>

    private lateinit var scheduleRecords: MutableList<ScheduleRecord>


}