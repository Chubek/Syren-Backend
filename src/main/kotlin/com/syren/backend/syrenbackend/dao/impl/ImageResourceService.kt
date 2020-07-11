package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.MediaResourceServiceInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.ImageResourceDto
import com.syren.backend.syrenbackend.repository.resource.ImageResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class ImageResourceService: MediaResourceServiceInterface<ImageResourceDto> {

    @Autowired
    private lateinit var imageResourceRepository: ImageResourceRepository

    override fun createResource(resourceDto: ImageResourceDto): String {
        return imageResourceRepository.save(resourceDto).id
    }

    override fun updateResource(resourceDto: ImageResourceDto) {
        imageResourceRepository.save(resourceDto)
    }

    override fun deleteResource(id: String) {
        imageResourceRepository.deleteById(id)
    }

    override fun getResource(id: String): Optional<ImageResourceDto> {
        return imageResourceRepository.findById(id)
    }
}