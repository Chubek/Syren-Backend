package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.OwnershipDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.OwnershipDto
import com.syren.backend.syrenbackend.repository.ownership.OwnershipRepository
import org.springframework.beans.factory.annotation.Autowired

class OwnershipDao: OwnershipDaoInterface {

    @Autowired
    private lateinit var ownershipRepository: OwnershipRepository

    override fun createOwnership(ownershipDto: OwnershipDto): String {
        return ownershipRepository.save(ownershipDto).id
    }

    override fun updateOwnership(ownershipDto: OwnershipDto) {
        ownershipRepository.save(ownershipDto)
    }

    override fun getOwnership(id: String): OwnershipDto {
        return ownershipRepository.findById(id).get()
    }

    override fun getOwnershipByModeratorId(moderatorId: String): OwnershipDto {
        return ownershipRepository.findByModeratorId(moderatorId)
    }

    override fun deleteOwnership(id: String) {
        ownershipRepository.deleteById(id)
    }

}