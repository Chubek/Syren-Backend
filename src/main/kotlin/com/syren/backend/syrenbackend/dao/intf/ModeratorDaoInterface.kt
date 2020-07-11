package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.ModeratorDto
import com.syren.backend.syrenbackend.model.moderator.Moderator

interface ModeratorDaoInterface {

    fun registerModerator(moderatorDto: ModeratorDto): String

    fun authModerator(mobileNumber: String, password: String): ModeratorDto

    fun updateModerator(moderatorDto: ModeratorDto, token: String)

    fun setAccessPhrase(id: String, accessPhrase: String): String

    fun verifyAccessPhrase(int: String, phraseToken: String): Boolean

    fun deleteModerator(id: String)

}