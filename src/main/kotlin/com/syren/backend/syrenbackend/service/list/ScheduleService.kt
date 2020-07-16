package com.syren.backend.syrenbackend.service.list

import com.beust.klaxon.Klaxon
import com.syren.backend.syrenbackend.dao.impl.ScheduleDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.list.Schedule
import com.syren.backend.syrenbackend.subschema.dataclass.ScheduleDate
import org.springframework.beans.factory.annotation.Autowired

class ScheduleService {

    @Autowired
    private lateinit var scheduleDao: ScheduleDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createSchedule(streamId: String, scheduleDateJson: String): String {

        val scheduleDatesList = Klaxon().parseArray<ScheduleDate>(scheduleDateJson)

        val schedule = Schedule(streamId = streamId, playDates = scheduleDatesList!!.toMutableList())


    }

}