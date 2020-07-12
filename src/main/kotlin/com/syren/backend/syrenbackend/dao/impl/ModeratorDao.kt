package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.ModeratorDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto
import com.syren.backend.syrenbackend.repository.moderator.ModeratorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*


@Component
class ModeratorDao: ModeratorDaoInterface {

    @Autowired
    private lateinit var moderatorRepository: ModeratorRepository

    override fun createModerator(moderatorDto: ModeratorDto): String {
        return moderatorRepository.save(moderatorDto).id
    }

    override fun deleteModerator(id: String) {
        moderatorRepository.deleteById(id)
    }

    override fun findByEmail(email: String): ModeratorDto {
        return moderatorRepository.findByEmail(email)
    }

    override fun findByFirstName(firstName: String): ModeratorDto {
        return moderatorRepository.findByFirstName(firstName)
    }

    override fun findByLastName(lastName: String): ModeratorDto {
        return moderatorRepository.findByLastName(lastName)
    }

    override fun findByMobileNumber(mobileNumber: String): ModeratorDto {
        return moderatorRepository.findByMobileNumber(mobileNumber)
    }

    override fun getModerator(id: String): Optional<ModeratorDto> {
        return moderatorRepository.findById(id)
    }

    override fun updateModerator(moderatorDto: ModeratorDto) {
        moderatorRepository.save(moderatorDto)
    }



}