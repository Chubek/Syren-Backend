package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.dto.modeldataclass.StreamLayoutTemplateDto
import org.springframework.data.mongodb.repository.MongoRepository

interface StreamLayoutTemplateRepository: MongoRepository<StreamLayoutTemplateDto, String>