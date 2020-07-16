package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.ScheduleDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.ScheduleDto
import com.syren.backend.syrenbackend.repository.list.ScheduleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import java.util.*


@Component
@ComponentScan
class ScheduleDao: ScheduleDaoInterface {

    @Autowired
    private lateinit var scheduleRepository: ScheduleRepository

    override fun createSchedule(scheduleDto: ScheduleDto): String {
        return scheduleRepository.save(scheduleDto).id
    }

    override fun updateSchedule(scheduleDto: ScheduleDto) {
        scheduleRepository.save(scheduleDto)
    }

    override fun findByPlaylistId(playListId: String): ScheduleDto {
        return scheduleRepository.findByPlayListId(playListId)
    }

    override fun getSchedule(id: String): Optional<ScheduleDto> {
        return scheduleRepository.findById(id)
    }

    override fun deleteSchedule(id: String) {
        scheduleRepository.deleteById(id)
    }

}