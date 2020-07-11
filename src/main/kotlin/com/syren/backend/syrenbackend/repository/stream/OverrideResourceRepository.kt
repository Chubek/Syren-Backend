package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideResourceDto
import org.springframework.data.mongodb.repository.MongoRepository

interface OverrideResourceRepository: MongoRepository<OverrideResourceDto, String>