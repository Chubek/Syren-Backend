package com.syren.backend.syrenbackend.dto.modeldataclass

import com.syren.backend.syrenbackend.service.dataclass.ListItem
import com.syren.backend.syrenbackend.service.dataclass.NotificationAlert
import com.syren.backend.syrenbackend.service.dataclass.ScheduleDate
import com.syren.backend.syrenbackend.service.dataclass.info.FileInfo
import com.syren.backend.syrenbackend.service.dataclass.info.MonitorInformation
import com.syren.backend.syrenbackend.service.dataclass.records.*
import java.util.*

data class MonitorDto(val Id: String, val currentStreamId: String, val formerStreams: MutableList<MonitorRecord>, val defaultStreamId: String, val accessPhrase: String, val information: MonitorInformation)
data class PlayListDto(val id: String, val items: MutableList<ListItem>, val records: MutableList<PlayListRecord>)
data class ScheduleDto(val id: String, val playListId: String, val playDates: MutableList<ScheduleDate>, val scheduleRecords: MutableList<ScheduleRecord>)
data class ModeratorDto(val id: String, val email: String, val password: String, val firstName: String, val lastName: String, val mobileNumber: String)
data class AudioResourceDto(val id: String, val record: MutableList<ResourceRecord>, val fileInfo: FileInfo, val metadata: Metadata)
data class ImageResourceDto(val id: String, val record: MutableList<ResourceRecord>, val fileInfo: FileInfo, val metadata: Metadata)
data class VideoResourceDto(val id: String, val record: MutableList<ResourceRecord>, val fileInfo: FileInfo, val metadata: Metadata)
data class WebPageResourceDto(val id: String, val record: MutableList<ResourceRecord>, val fileInfo: FileInfo, val metadata: Metadata)
data class WidgetResourceDto(val id: String, val record: MutableList<ResourceRecord>, val htmlFilePath: String)
data class OverrideMessageDto(val id: String, val name: String, val javaScriptFileLocation: String)
data class OverrideResourceDto(val id: String, val notificationAlert: NotificationAlert, val records: MutableList<OverrideRecord>)
data class StreamDto(val id: String, val scheduleIds: MutableList<String>, val records: MutableList<StreamRecord>, val pathToTemplate: String)
