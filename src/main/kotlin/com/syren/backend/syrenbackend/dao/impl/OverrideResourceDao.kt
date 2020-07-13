package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.OverrideResourceDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.OverrideResourceDto
 import com.syren.backend.syrenbackend.repository.stream.OverrideResourceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import java.util.*


@Component
@ComponentScan
class OverrideResourceDao: OverrideResourceDaoInterface {

    @Autowired
    private lateinit var overrideResourceRepository: OverrideResourceRepository

    override fun createOverrideResource(overrideResourceDto: OverrideResourceDto): String {
        return overrideResourceRepository.save(overrideResourceDto).id
    }

    override fun updateOverrideResource(overrideResourceDto: OverrideResourceDto) {
        overrideResourceRepository.save(overrideResourceDto)
    }

    override fun getOverrideResource(id: String): Optional<OverrideResourceDto> {
        return overrideResourceRepository.findById(id)
    }

    override fun deleteOverrideResource(id: String) {
        overrideResourceRepository.deleteById(id)
    }

}