package com.syren.backend.syrenbackend.repository.display

import com.syren.backend.syrenbackend.dto.modeldataclass.MonitorDto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

@Component
interface MonitorRepository: MongoRepository<MonitorDto, String> {

    fun findByCurrentStreamId(currentStreamId: String): MonitorDto

    fun findByDefaultStreamId(defaultStreamId: String): MonitorDto

    fun findByAccessPhrase(accessPhrase: String): MonitorDto


}