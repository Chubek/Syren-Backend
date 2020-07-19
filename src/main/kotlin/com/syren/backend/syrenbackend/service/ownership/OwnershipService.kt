package com.syren.backend.syrenbackend.service.ownership

import com.syren.backend.syrenbackend.dao.impl.OwnershipDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.ownership.Ownership
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service


@Service
@ComponentScan
class OwnershipService {

    @Autowired
    private lateinit var ownershipDao: OwnershipDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createOwnershipModel(moderatorId: String): String {

        val ownership = Ownership(moderatorId = moderatorId, mediaResourcesList = mutableListOf(), scheduleLists = mutableListOf(),
                scriptResourcesList = mutableListOf(), overrideMessagesList = mutableListOf(), overrideResourcesList = mutableListOf(),
                playListsList = mutableListOf(), streamsList = mutableListOf())

        return ownershipDao.createOwnership(dtoMappers.ownershipMapperDto(ownership))

    }

    fun addToOwnershipMediaList(moderatorId: String, resourceId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.mediaResourcesList.add(resourceId)

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun addToOwnershipScriptList(moderatorId: String, resourceId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.scriptResourcesList.add(resourceId)

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun addToOwnershipScheduleList(moderatorId: String, scheduleId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.scheduleLists.add(scheduleId)

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun addToOwnershipOverrideResourceList(moderatorId: String, resourceId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.overrideResourcesList.add(resourceId)

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun addToOwnershipOverrideMessageList(moderatorId: String, overrideId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.overrideMessagesList.add(overrideId)

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun addToOwnershipStreamList(moderatorId: String, streamId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.streamsList.add(streamId)

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun addToOwnershipPlayListList(moderatorId: String, playlistId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.playListsList.add(playlistId)

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun removeFromOwnershipMediaList(moderatorId: String, resourceId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.mediaResourcesList.filter { it != resourceId }

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun removeFromOwnershipScriptList(moderatorId: String, resourceId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.scriptResourcesList.filter { it != resourceId }

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun removeFromOwnershipScheduleList(moderatorId: String, scheduleId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.scheduleLists.filter { it != scheduleId }

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }


    fun removeFromOwnershipOverrideResourceList(moderatorId: String, resourceId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.overrideResourcesList.filter { it != resourceId }

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun removeFromOwnershipOverrideMessageList(moderatorId: String, overrideId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.overrideMessagesList.filter { it != overrideId }

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun removeFromOwnershipStreamList(moderatorId: String, streamId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.streamsList.filter { it != streamId }

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun removeFromOwnershipPlayListList(moderatorId: String, playlistId: String) {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        var ownership = dtoMappers.ownershipMapperEntity(ownershipDto)

        ownership.playListsList.filter { it != playlistId }

        ownershipDao.updateOwnership(dtoMappers.ownershipMapperDto(ownership))


    }

    fun getOwnership(moderatorId: String): Ownership {

        val ownershipDto = ownershipDao.getOwnershipByModeratorId(moderatorId)

        return dtoMappers.ownershipMapperEntity(ownershipDto)
    }


}