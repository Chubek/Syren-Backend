package com.syren.backend.syrenbackend.service.list

import com.syren.backend.syrenbackend.dao.impl.ScheduleDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.list.Schedule
import com.syren.backend.syrenbackend.subschema.dataclass.ScheduleDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service

@Service
@ComponentScan
class ScheduleService {

    @Autowired
    private lateinit var scheduleDao: ScheduleDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createSchedule(streamId: String, scheduleDate: MutableList<ScheduleDate>): String {

        val schedule = Schedule(streamId = streamId, playDates = scheduleDate)

        val scheduleDto = dtoMappers.scheduleMapperDto(schedule)

        return scheduleDao.createSchedule(scheduleDto)

    }

    fun editStreamId(id: String, streamId: String) {
        val scheduleDto = scheduleDao.getSchedule(id)

        var schedule = dtoMappers.scheduleMapperEntity(scheduleDto.get())

        schedule.streamId = streamId

        scheduleDao.updateSchedule(dtoMappers.scheduleMapperDto(schedule))

    }

    fun addDateToSchedule(id: String, date: ScheduleDate) {

        val scheduleDto = scheduleDao.getSchedule(id)

        var schedule = dtoMappers.scheduleMapperEntity(scheduleDto.get())

        schedule.playDates.add(date)

        scheduleDao.updateSchedule(dtoMappers.scheduleMapperDto(schedule))
    }

    fun remoteDateFromSchedule(id: String, date: ScheduleDate) {

        val scheduleDto = scheduleDao.getSchedule(id)

        var schedule = dtoMappers.scheduleMapperEntity(scheduleDto.get())

        schedule.playDates.filter { it != date }

        scheduleDao.updateSchedule(dtoMappers.scheduleMapperDto(schedule))
    }

    fun deleteSchedule(id: String) {

        scheduleDao.deleteSchedule(id)
    }

}