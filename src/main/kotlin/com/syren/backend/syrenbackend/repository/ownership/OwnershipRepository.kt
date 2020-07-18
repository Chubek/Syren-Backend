package com.syren.backend.syrenbackend.repository.ownership

import com.syren.backend.syrenbackend.dto.modeldataclass.OwnershipDto
import org.springframework.data.mongodb.repository.MongoRepository

interface OwnershipRepository: MongoRepository<OwnershipDto, String> {

    fun findByModeratorId(id: String): OwnershipDto

}