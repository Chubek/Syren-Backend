package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.ScriptResourceDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.WidgetResourceDto
import com.syren.backend.syrenbackend.repository.resource.WidgetResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


@Component
class WidgetResourceDao: ScriptResourceDaoInterface<WidgetResourceDto> {
    
    @Autowired
    private lateinit var widgetResourceRepository: WidgetResourceRepository

    override fun createScriptResource(scriptResourceDto: WidgetResourceDto): String {
        return widgetResourceRepository.save(scriptResourceDto).id
    }

    override fun getScriptResource(id: String): Optional<WidgetResourceDto> {
        return widgetResourceRepository.findById(id)
    }

    override fun deleteScriptResource(id: String) {
        widgetResourceRepository.deleteById(id)
    }

    override fun updateScriptResource(id: String, scriptResourceDto: WidgetResourceDto) {
        widgetResourceRepository.save(scriptResourceDto)
    }

}