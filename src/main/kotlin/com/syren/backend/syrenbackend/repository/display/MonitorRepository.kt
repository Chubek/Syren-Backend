package com.syren.backend.syrenbackend.repository.display

import com.syren.backend.syrenbackend.model.display.Monitor
import org.springframework.data.mongodb.repository.MongoRepository

interface MonitorRepository: MongoRepository<Monitor, String> {

    fun findByCurrentStreamId(currentStreamId: String): Monitor

    fun findByDefaultStreamId(defaultStreamId: String): Monitor

    fun findByAccessPhrase(accessPhrase: String): Monitor


}