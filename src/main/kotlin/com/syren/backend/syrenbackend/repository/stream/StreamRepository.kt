package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.dto.modeldataclass.StreamDto
import org.springframework.data.mongodb.repository.MongoRepository

interface StreamRepository: MongoRepository<StreamDto, String>