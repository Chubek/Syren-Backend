package com.syren.backend.syrenbackend.service.resource

import com.syren.backend.syrenbackend.dao.impl.MediaResourceDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.resource.MediaResource
import com.syren.backend.syrenbackend.repository.resource.MediaResourceRepository
import com.syren.backend.syrenbackend.subschema.dataclass.info.FileInfo
import com.syren.backend.syrenbackend.subschema.enumclass.MediaType
import org.springframework.beans.factory.annotation.Autowired
import java.time.Instant
import java.util.*

class MediaResourceService {

    @Autowired
    private lateinit var mediaResourceDao: MediaResourceDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createMediaResource(fileName: String, fileType: String, bucketName: String): String {

        val now = Date.from(Instant.now())

        val fileInfo = FileInfo(dateUploaded = now, bucket = bucketName, fileName = fileName)

        val mediaResource = MediaResource(fileInfo = fileInfo, type = MediaType.valueOf(fileType))

        val mediaResourceDto = dtoMappers.mediaResourceMapperDto(mediaResource)

        return mediaResourceDao.createResource(mediaResourceDto)

    }

    fun getMediaResource(id: String): MediaResource {

        val mediaResourceDto = mediaResourceDao.getResource(id)

        return dtoMappers.mediaResourceMapperEntity(mediaResourceDto.get())

    }







}