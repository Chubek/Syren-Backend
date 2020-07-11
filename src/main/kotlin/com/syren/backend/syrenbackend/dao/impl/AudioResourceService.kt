package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.MediaResourceServiceInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.AudioResourceDto
import com.syren.backend.syrenbackend.repository.resource.AudioResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class AudioResourceService: MediaResourceServiceInterface<AudioResourceDto> {

    @Autowired
    private lateinit var audioResourceRepository: AudioResourceRepository

    override fun createResource(resourceDto: AudioResourceDto): String {
        return audioResourceRepository.save(resourceDto).id
    }

    override fun updateResource(resourceDto: AudioResourceDto) {
        audioResourceRepository.save(resourceDto)
    }

    override fun deleteResource(id: String) {
        audioResourceRepository.deleteById(id)
    }

    override fun getResource(id: String): Optional<AudioResourceDto> {
        return audioResourceRepository.findById(id)
    }
}