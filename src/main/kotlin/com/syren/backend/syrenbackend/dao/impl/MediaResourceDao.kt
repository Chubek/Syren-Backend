package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.MediaResourceDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.MediaResourceDto
import com.syren.backend.syrenbackend.repository.resource.MediaResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import java.util.*
import javax.print.attribute.standard.Media

@Component
@ComponentScan
class MediaResourceDao: MediaResourceDaoInterface<MediaResourceDto> {

    @Autowired
    private lateinit var mediaResourceRepository: MediaResourceRepository

    override fun createResource(resourceDto: MediaResourceDto): String {
        return mediaResourceRepository.save(resourceDto).id
    }

    override fun updateResource(resourceDto: MediaResourceDto) {
        mediaResourceRepository.save(resourceDto)
    }

    override fun deleteResource(id: String) {
        mediaResourceRepository.deleteById(id)
    }

    override fun getResource(id: String): Optional<MediaResourceDto> {
        return mediaResourceRepository.findById(id)
    }
}