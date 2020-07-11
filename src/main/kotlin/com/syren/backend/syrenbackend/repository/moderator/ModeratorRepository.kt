package com.syren.backend.syrenbackend.repository.moderator

import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto
import org.springframework.data.mongodb.repository.MongoRepository

interface ModeratorRepository: MongoRepository<ModeratorDto, String> {

    fun findByEmail(email: String): ModeratorDto

    fun findByMobileNumber(mobileNumber: String): ModeratorDto

    fun findByFirstName(firstName: String): ModeratorDto

    fun findByLastName(lastName: String): ModeratorDto
}