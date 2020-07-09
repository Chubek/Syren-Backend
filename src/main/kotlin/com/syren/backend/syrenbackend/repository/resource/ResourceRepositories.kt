package com.syren.backend.syrenbackend.repository.resource

import com.syren.backend.syrenbackend.model.resource.*
import org.springframework.data.mongodb.repository.MongoRepository

interface AudioResourceRepository: MongoRepository<AudioResource, String>

interface VideoResourceRepository: MongoRepository<VideoResource, String>

interface ImageResourceRepository: MongoRepository<ImageResource, String>

interface WebPageResourceRepository: MongoRepository<WebPageResource, String>

interface WidgetResourceRepository: MongoRepository<WidgetResource, String>