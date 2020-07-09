package com.syren.backend.syrenbackend.service.database.`interface`

import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto

interface ModeratorServiceInterface {

    fun registerModerator(moderatorDto: ModeratorDto): String

    fun authModerator(mobileNumber: String, password: String): Boolean

    fun updateModerator(moderatorDto: ModeratorDto)



}