package com.syren.backend.syrenbackend.repository.resource

import com.syren.backend.syrenbackend.dto.modeldataclass.*
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Component


@Component
interface AudioResourceRepository: MongoRepository<AudioResourceDto, String>

@Component
interface VideoResourceRepository: MongoRepository<VideoResourceDto, String>

@Component
interface ImageResourceRepository: MongoRepository<ImageResourceDto, String>

@Component
interface WebPageResourceRepository: MongoRepository<WebPageResourceDto, String>

@Component
interface WidgetResourceRepository: MongoRepository<WidgetResourceDto, String>