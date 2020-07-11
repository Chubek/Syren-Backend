package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.PlayListDto
import com.syren.backend.syrenbackend.model.list.PlayList
import com.syren.backend.syrenbackend.subschema.dataclass.ListItem
import com.syren.backend.syrenbackend.subschema.dataclass.records.PlayListRecord

interface PlayListDaoInterface {

    fun createPlayList(playListDto: PlayListDto): String

    fun addItem(id: String, listItem: ListItem)

    fun getPlayList(id: String): PlayListDto

    fun deletePlayList(id: String)

}