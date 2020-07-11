package com.syren.backend.syrenbackend.dao.intf

import com.syren.backend.syrenbackend.dto.modeldataclass.PlayListDto
import com.syren.backend.syrenbackend.model.list.PlayList
import com.syren.backend.syrenbackend.subschema.dataclass.ListItem
import com.syren.backend.syrenbackend.subschema.dataclass.records.PlayListRecord

interface PlayListServiceInterface {

    fun createPlayList(playListDto: PlayListDto): String

    fun addItem(id: String, listItem: ListItem): Void

    fun getPlayList(id: String): PlayList

    fun deletePlayList(id: String): Void

}