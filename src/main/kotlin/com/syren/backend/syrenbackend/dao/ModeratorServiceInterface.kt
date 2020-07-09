package com.syren.backend.syrenbackend.dao

import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto
import com.syren.backend.syrenbackend.model.moderator.Moderator

interface ModeratorServiceInterface {

    fun registerModerator(moderatorDto: ModeratorDto): String

    fun authModerator(mobileNumber: String, password: String): Moderator

    fun updateModerator(moderatorDto: ModeratorDto, token: String)

    fun setAccessPhrase(id: String, accessPhrase: String): String

    fun verifyAccessPhrase(int: String, phraseToken: String): Boolean

    fun deleteModerator(id: String): Void

}