package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto
import com.syren.backend.syrenbackend.model.moderator.Moderator
import java.util.*

interface ModeratorDaoInterface {

    fun createModerator(moderatorDto: ModeratorDto): String

    fun getModerator(id: String): Optional<ModeratorDto>

    fun updateModerator(moderatorDto: ModeratorDto)

    fun findByEmail(email: String): ModeratorDto

    fun findByMobileNumber(mobileNumber: String): ModeratorDto

    fun findByFirstName(firstName: String): ModeratorDto

    fun findByLastName(lastName: String): ModeratorDto

    fun deleteModerator(id: String)

}