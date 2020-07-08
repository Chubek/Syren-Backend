package com.syren.backend.syrenbackend.repository.list

import com.syren.backend.syrenbackend.model.list.Schedule
import org.springframework.data.mongodb.repository.MongoRepository

interface ScheduleRepository: MongoRepository<Schedule, String> {

    fun findByPlayListId(playListId: String): Schedule

}