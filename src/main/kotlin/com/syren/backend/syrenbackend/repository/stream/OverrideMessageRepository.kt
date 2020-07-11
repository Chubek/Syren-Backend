package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideMessageDto
import org.springframework.data.mongodb.repository.MongoRepository

interface OverrideMessageRepository: MongoRepository<OverrideMessageDto, String>