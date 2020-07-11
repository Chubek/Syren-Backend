package com.syren.backend.syrenbackend.repository.resource

import com.syren.backend.syrenbackend.dto.modeldataclass.*
import org.springframework.data.mongodb.repository.MongoRepository

interface AudioResourceRepository: MongoRepository<AudioResourceDto, String>

interface VideoResourceRepository: MongoRepository<VideoResourceDto, String>

interface ImageResourceRepository: MongoRepository<ImageResourceDto, String>

interface WebPageResourceRepository: MongoRepository<WebPageResourceDto, String>

interface WidgetResourceRepository: MongoRepository<WidgetResourceDto, String>