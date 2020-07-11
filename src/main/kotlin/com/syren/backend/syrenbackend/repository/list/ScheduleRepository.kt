package com.syren.backend.syrenbackend.repository.list

import com.syren.backend.syrenbackend.dto.modeldataclass.ScheduleDto
import org.springframework.data.mongodb.repository.MongoRepository

interface ScheduleRepository: MongoRepository<ScheduleDto, String> {

    fun findByPlayListId(playListId: String): ScheduleDto

}