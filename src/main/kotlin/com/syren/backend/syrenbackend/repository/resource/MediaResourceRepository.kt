package com.syren.backend.syrenbackend.repository.resource

import com.syren.backend.syrenbackend.dto.modeldataclass.MediaResourceDto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

@Component
interface MediaResourceRepository: MongoRepository<MediaResourceDto, String>