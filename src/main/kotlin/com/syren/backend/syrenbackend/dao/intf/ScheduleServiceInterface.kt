package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.ScheduleDto
import com.syren.backend.syrenbackend.model.list.Schedule

interface ScheduleServiceInterface {

    fun createSchedule(scheduleDto: ScheduleDto): String

    fun updateSchedule(id: String, scheduleDto: ScheduleDto): Void

    fun getSchedule(id: String): Schedule

    fun deleteSchedule(id: String): Void

}