package com.syren.backend.syrenbackend.dto.modeldataclass

import com.syren.backend.syrenbackend.subschema.dataclass.ListItem
import com.syren.backend.syrenbackend.subschema.dataclass.NotificationAlert
import com.syren.backend.syrenbackend.subschema.dataclass.ScheduleDate
import com.syren.backend.syrenbackend.subschema.dataclass.info.FileInfo
import com.syren.backend.syrenbackend.subschema.dataclass.info.MonitorInformation
import com.syren.backend.syrenbackend.subschema.dataclass.info.TemplateInfo
import com.syren.backend.syrenbackend.subschema.dataclass.records.*
import com.syren.backend.syrenbackend.subschema.dataclass.records.*
import java.util.*

data class MonitorDto(val Id: String, val currentStreamId: String, val formerStreams: MutableList<MonitorRecord>, val defaultStreamId: String, val accessPhrase: String, val information: MonitorInformation)
data class PlayListDto(val id: String, val items: MutableList<ListItem>)
data class ScheduleDto(val id: String, val streamId: String, val playDates: MutableList<ScheduleDate>)
data class ModeratorDto(val id: String, val email: String, val password: String, val firstName: String, val lastName: String, val mobileNumber: String)
data class AudioResourceDto(val id: String, val fileInfo: FileInfo, val metadata: Metadata)
data class ImageResourceDto(val id: String, val fileInfo: FileInfo, val metadata: Metadata)
data class VideoResourceDto(val id: String, val fileInfo: FileInfo, val metadata: Metadata)
data class WebPageResourceDto(val id: String, val record: MutableList<ResourceRecord>, val fileInfo: FileInfo, val metadata: Metadata)
data class WidgetResourceDto(val id: String, val record: MutableList<ResourceRecord>, val htmlFilePath: String)
data class OverrideMessageDto(val id: String, val name: String, val notificationAlert: NotificationAlert)
data class OverrideResourceDto(val id: String, val resourceId: String)
data class StreamDto(val id: String, val playlistIds: MutableList<String>, val pathToTemplate: String)
data class StreamLayoutTemplateDto(val id: String, val templateInfo: TemplateInfo, val fileLocation: String)
