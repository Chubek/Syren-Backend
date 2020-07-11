package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.MediaResourceServiceInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.AudioResourceDto
import com.syren.backend.syrenbackend.model.resource.AudioResource

class AudioResourceService: MediaResourceServiceInterface<AudioResourceDto, AudioResource> {

    override fun createResource(resourceDto: AudioResourceDto): String {
        TODO("Not yet implemented")
    }

    override fun updateResource(resourceDto: AudioResourceDto): Void {
        TODO("Not yet implemented")
    }

    override fun deleteResource(resourceDto: AudioResourceDto): Void {
        TODO("Not yet implemented")
    }

    override fun getResource(id: String): AudioResource {
        TODO("Not yet implemented")
    }
}