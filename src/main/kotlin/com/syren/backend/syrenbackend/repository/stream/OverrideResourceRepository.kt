package com.syren.backend.syrenbackend.repository.stream

import com.syren.backend.syrenbackend.model.stream.OverrideResource
import org.springframework.data.mongodb.repository.MongoRepository

interface OverrideResourceRepository: MongoRepository<OverrideResource, String>