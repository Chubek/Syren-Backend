package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.PlayListDto
import com.syren.backend.syrenbackend.model.list.PlayList
import com.syren.backend.syrenbackend.subschema.dataclass.ListItem
import com.syren.backend.syrenbackend.subschema.dataclass.records.PlayListRecord
import java.util.*

interface PlayListDaoInterface {

    fun createPlayList(playListDto: PlayListDto): String

    fun updatePlaylist(playListDto: PlayListDto)

    fun getPlayList(id: String): Optional<PlayListDto>

    fun deletePlayList(id: String)

}