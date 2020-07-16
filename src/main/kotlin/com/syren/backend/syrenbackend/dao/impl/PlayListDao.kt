package com.syren.backend.syrenbackend.dao.impl

import com.syren.backend.syrenbackend.dao.intf.PlayListDaoInterface
import com.syren.backend.syrenbackend.dto.modeldataclass.PlayListDto
import com.syren.backend.syrenbackend.repository.list.PlayListRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component
import java.util.*


@Component
@ComponentScan
class PlayListDao: PlayListDaoInterface {

    @Autowired
    private lateinit var playListRepository: PlayListRepository

    override fun createPlayList(playListDto: PlayListDto): String {
        return playListRepository.save(playListDto).id
    }

    override fun getPlayList(id: String): Optional<PlayListDto> {
        return playListRepository.findById(id)
    }

    override fun updatePlaylist(playListDto: PlayListDto) {
        playListRepository.save(playListDto)
    }

    override fun deletePlayList(id: String) {
        playListRepository.deleteById(id)
    }


}