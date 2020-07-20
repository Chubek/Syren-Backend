package com.syren.backend.syrenbackend.service.list

import com.syren.backend.syrenbackend.dao.impl.PlayListDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.list.PlayList
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Service


@Service
@ComponentScan
class PlayListService {

    @Autowired
    private lateinit var playListDao: PlayListDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createPlayList(resources: MutableList<String>): String {

        val playList = PlayList(items = resources)

        val playListDto = dtoMappers.playListMapperDto(playList)

        return playListDao.createPlayList(playListDto)

    }

    fun removeFromPlayList(id: String, resourceId: String) {

        val playListDto = playListDao.getPlayList(id)

        val playList = dtoMappers.playListMapperEntity(playListDto.get())

        playList.items.filter { it != resourceId }

        playListDao.updatePlaylist(dtoMappers.playListMapperDto(playList))

    }

    fun addToPlayList(id: String, resourceId: String) {

        val playListDto = playListDao.getPlayList(id)

        val playList = dtoMappers.playListMapperEntity(playListDto.get())

        playList.items.add(resourceId)

        playListDao.updatePlaylist(dtoMappers.playListMapperDto(playList))
    }

    fun getPlayList(id: String): PlayList {
        return dtoMappers.playListMapperEntity(playListDao.getPlayList(id).get())
    }

    fun deletePlayList(id: String) {

        playListDao.deletePlayList(id)

    }


}