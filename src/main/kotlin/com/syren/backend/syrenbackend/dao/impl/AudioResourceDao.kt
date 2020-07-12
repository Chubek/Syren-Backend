package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.MediaResourceDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.AudioResourceDto
import com.syren.backend.syrenbackend.repository.resource.AudioResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class AudioResourceDao: MediaResourceDaoInterface<AudioResourceDto> {

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