package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.StreamDto

interface StreamServiceInterface {

    fun createStream(streamDto: StreamDto): String

    fun appendPlaylists(id: String, playListId: String)

    fun changeStreamLayoutFile(id: String, layoutLocation: String)

    fun deleteStream(id: String)
}