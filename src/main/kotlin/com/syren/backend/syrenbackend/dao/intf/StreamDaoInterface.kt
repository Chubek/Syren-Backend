package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.StreamDto
import java.util.*

interface StreamDaoInterface {

    fun createStream(streamDto: StreamDto): String

    fun updateStream(streamDto: StreamDto)

    fun getStream(id: String): Optional<StreamDto>

    fun deleteStream(id: String)
}