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

        val scheduleDto = dtoMappers.scheduleMapperDto(schedule)

        return scheduleDao.createSchedule(scheduleDto)

    }

    fun editStreamId(id: String, streamId: String) {
        val scheduleDto = scheduleDao.getSchedule(id)

        var schedule = dtoMappers.scheduleMapperEntity(scheduleDto.get())

        schedule.streamId = streamId

        scheduleDao.updateSchedule(dtoMappers.scheduleMapperDto(schedule))

    }

    fun addDateToSchedule(id: String, dateJson: String) {

        val scheduleDate = Klaxon().parse<ScheduleDate>(dateJson)

        val scheduleDto = scheduleDao.getSchedule(id)

        var schedule = dtoMappers.scheduleMapperEntity(scheduleDto.get())

        schedule.playDates.add(scheduleDate!!)

        scheduleDao.updateSchedule(dtoMappers.scheduleMapperDto(schedule))
    }

    fun remoteDateFromSchedule(id: String, dateJson: String) {

        val scheduleDate = Klaxon().parse<ScheduleDate>(dateJson)

        val scheduleDto = scheduleDao.getSchedule(id)

        var schedule = dtoMappers.scheduleMapperEntity(scheduleDto.get())

        schedule.playDates.filter { it != scheduleDate }

        scheduleDao.updateSchedule(dtoMappers.scheduleMapperDto(schedule))
    }

    fun deleteSchedule(id: String) {

        scheduleDao.deleteSchedule(id)
    }

}