package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.StreamDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.StreamDto
import com.syren.backend.syrenbackend.repository.stream.StreamRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import java.util.*


@Component
@ComponentScan
class StreamDao: StreamDaoInterface {

    @Autowired
    private lateinit var streamRepository: StreamRepository

    override fun createStream(streamDto: StreamDto): String {
        return streamRepository.save(streamDto).id
    }

    override fun updateStream(streamDto: StreamDto) {
        streamRepository.save(streamDto)
    }

    override fun deleteStream(id: String) {
        streamRepository.deleteById(id)
    }

    override fun getStream(id: String): Optional<StreamDto> {
        return streamRepository.findById(id)
    }

}