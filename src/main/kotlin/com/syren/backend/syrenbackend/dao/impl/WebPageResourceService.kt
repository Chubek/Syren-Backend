package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.ScriptResourceServiceInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.WebPageResourceDto
import com.syren.backend.syrenbackend.repository.resource.WebPageResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

class WebPageResourceService: ScriptResourceServiceInterface<WebPageResourceDto> {

    @Autowired
    private lateinit var webPageResourceRepository: WebPageResourceRepository

    override fun createScriptResource(scriptResourceDto: WebPageResourceDto): String {
        return webPageResourceRepository.save(scriptResourceDto).id
    }

    override fun getScriptResource(id: String): Optional<WebPageResourceDto> {
        return webPageResourceRepository.findById(id)
    }

    override fun deleteScriptResource(id: String) {
        webPageResourceRepository.deleteById(id)
    }

    override fun updateScriptResource(id: String, scriptResourceDto: WebPageResourceDto) {
        webPageResourceRepository.save(scriptResourceDto)
    }

}