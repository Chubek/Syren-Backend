package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.OverrideMessageDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideMessageDto
import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideResourceDto
import com.syren.backend.syrenbackend.repository.stream.OverrideMessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class OverrideMessageDao: OverrideMessageDaoInterface {

    @Autowired
    private lateinit var overrideMessageRepository: OverrideMessageRepository

    override fun createOverrideMessage(overrideMessageDto: OverrideMessageDto): String {
        return overrideMessageRepository.save(overrideMessageDto).id
    }

    override fun updateOverrideMessage(overrideMessageDto: OverrideMessageDto) {
        overrideMessageRepository.save(overrideMessageDto)
    }

    override fun getOverrideMessage(id: String): Optional<OverrideMessageDto> {
        return overrideMessageRepository.findById(id)
    }

    override fun deleteOverrideMessage(id: String) {
        overrideMessageRepository.deleteById(id)
    }

}