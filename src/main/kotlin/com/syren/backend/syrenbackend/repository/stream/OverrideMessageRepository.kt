package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.model.stream.OverrideMessage
import org.springframework.data.mongodb.repository.MongoRepository

interface OverrideMessageRepository: MongoRepository<OverrideMessage, String>