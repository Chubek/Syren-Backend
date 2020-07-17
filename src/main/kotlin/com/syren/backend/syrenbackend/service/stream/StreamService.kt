package com.syren.backend.syrenbackend.service.stream

import com.syren.backend.syrenbackend.dao.impl.StreamDao
import com.syren.backend.syrenbackend.dto.mapper.DtoMappers
import com.syren.backend.syrenbackend.model.stream.Stream
import org.springframework.beans.factory.annotation.Autowired

class StreamService {

    @Autowired
    private lateinit var streamDao: StreamDao

    @Autowired
    private lateinit var dtoMappers: DtoMappers

    fun createStream(playListIds: MutableList<String>, pathToTemplate: String): String {

        val stream = Stream(pathToTemplate = pathToTemplate, playlistIds = playListIds)

        val streamDto = dtoMappers.streamMapperDto(stream)

        return streamDao.createStream(streamDto)

    }


    fun changePath(id: String, path: String) {

        val streamDto = streamDao.getStream(id)

        var stream = dtoMappers.streamMapperEntity(streamDto.get())

        stream.pathToTemplate = path

        streamDao.updateStream(dtoMappers.streamMapperDto(stream))

    }

    fun addToPlayListIds(id: String, playListId: String) {

        val streamDto = streamDao.getStream(id)

        var stream = dtoMappers.streamMapperEntity(streamDto.get())

        stream.playlistIds.add(playListId)

        streamDao.updateStream(dtoMappers.streamMapperDto(stream))

    }

    fun removeFromPlayListIds(id: String, playListId: String) {

        val streamDto = streamDao.getStream(id)

        var stream = dtoMappers.streamMapperEntity(streamDto.get())

        stream.playlistIds.filter { it != playListId }

        streamDao.updateStream(dtoMappers.streamMapperDto(stream))

    }

    fun deletePlayList(id: String) {
        streamDao.deleteStream(id)
    }

}