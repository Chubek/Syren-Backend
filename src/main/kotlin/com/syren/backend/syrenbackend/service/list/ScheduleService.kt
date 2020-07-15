package com.syren.backend.syrenbackend.service.list

import com.syren.backend.syrenbackend.dao.impl.ScheduleDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import org.springframework.beans.factory.annotation.Autowired

class ScheduleService {

    @Autowired
    private lateinit var scheduleDao: ScheduleDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createSchedule(streamId: String, scheduleDateJson: String): String {

        val scheduleDatesList = Klaxon()

    }

}