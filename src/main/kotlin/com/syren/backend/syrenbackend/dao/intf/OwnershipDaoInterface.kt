package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.OwnershipDto

interface OwnershipDaoInterface {

    fun createOwnership(ownershipDto: OwnershipDto): String

    fun updateOwnership(ownershipDto: OwnershipDto)

    fun getOwnership(id: String): OwnershipDto

    fun getOwnershipByModeratorId(moderatorId: String): OwnershipDto

    fun deleteOwnership(id: String)

}