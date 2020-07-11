package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.StreamDto

interface StreamServiceInterface {

    fun createStream(streamDto: StreamDto): String

    fun appendPlaylists(id: String, playListId: String): Void

    fun changeStreamLayoutFile(id: String, layoutLocation: String): Void

    fun deleteStream(id: String): Void
}