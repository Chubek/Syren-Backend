package com.syren.backend.syrenbackend.repository.moderator

import com.syren.backend.syrenbackend.model.moderator.Moderator
import org.springframework.data.mongodb.repository.MongoRepository

interface ModeratorRepository: MongoRepository<Moderator, String> {

    fun findByEmail(email: String): Moderator

    fun findByMobileNumber(mobileNumber: String): Moderator

    fun findByFirstName(firstName: String): Moderator

    fun findByLastName(lastName: String): Moderator
}