package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.model.stream.StreamLayoutTemplate
import org.springframework.data.mongodb.repository.MongoRepository

interface StreamLayoutTemplateRepository: MongoRepository<StreamLayoutTemplate, String>