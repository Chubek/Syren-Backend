package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.ScheduleDto
import com.syren.backend.syrenbackend.model.list.Schedule

interface ScheduleServiceInterface {

    fun createSchedule(scheduleDto: ScheduleDto): String

    fun updateSchedule(id: String, scheduleDto: ScheduleDto)

    fun getSchedule(id: String): ScheduleDto

    fun deleteSchedule(id: String)

}