package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.MediaResourceDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.VideoResourceDto
import com.syren.backend.syrenbackend.repository.resource.VideoResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class VideoResourceDao: MediaResourceDaoInterface<VideoResourceDto> {

    @Autowired
    private lateinit var videoResourceRepository: VideoResourceRepository

    override fun createResource(resourceDto: VideoResourceDto): String {
        return videoResourceRepository.save(resourceDto).id
    }

    override fun updateResource(resourceDto: VideoResourceDto) {
        videoResourceRepository.save(resourceDto)
    }

    override fun deleteResource(id: String) {
        videoResourceRepository.deleteById(id)
    }

    override fun getResource(id: String): Optional<VideoResourceDto> {
        return videoResourceRepository.findById(id)
    }

}