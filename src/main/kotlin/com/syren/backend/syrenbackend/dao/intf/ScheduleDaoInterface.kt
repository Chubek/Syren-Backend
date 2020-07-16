package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.ScheduleDto
import java.util.*

interface ScheduleDaoInterface {

    fun createSchedule(scheduleDto: ScheduleDto): String

    fun updateSchedule(scheduleDto: ScheduleDto)

    fun findByPlaylistId(playListId: String): ScheduleDto

    fun getSchedule(id: String): Optional<ScheduleDto>

    fun deleteSchedule(id: String)

}