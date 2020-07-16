package com.syren.backend.syrenbackend.repository.resource

import com.syren.backend.syrenbackend.dto.modeldataclass.WebPageResourceDto
import com.syren.backend.syrenbackend.dto.modeldataclass.WidgetResourceDto
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component

@Component
interface WebPageResourceRepository: MongoRepository<WebPageResourceDto, String>

@Component
interface WidgetResourceRepository: MongoRepository<WidgetResourceDto, String>



