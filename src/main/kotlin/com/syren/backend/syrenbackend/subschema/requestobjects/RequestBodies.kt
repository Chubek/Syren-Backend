package com.syren.backend.syrenbackend.subschema.requestobjects

import com.syren.backend.syrenbackend.subschema.dataclass.NotificationAlert
import com.syren.backend.syrenbackend.subschema.dataclass.ScheduleDate
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorOrientation
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorSoundOutput
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.MonitorStatus
import com.syren.backend.syrenbackend.subschema.dataclass.enumclass.WifiMode
import java.util.*

data class BucketName(val bucketName: String, val fileType: String)
data class PlayListId(val playListIds: List<String>)
data class Message(val message: NotificationAlert)
data class ResourceId(val resourceIds: List<String>)
data class ScheduleRequestBody(val streamId: String, val scheduleDates: List<ScheduleDate>)
data class ScheduleDate(val scheduleDate: ScheduleDate)
data class StreamId(val streamId: String)
data class BasicMonitorInfoRequest(val tags: List<String>, val monitorOrientation: String, val monitorStatus: String)
data class MonitorLocationRequest(val city: String, val lat: Double, val lng: Double)
data class MonitorNetworkRequest(val wifiEnabled: Boolean, val networkName: String, val wifiMode: String, val hidden: Boolean, val checkSum: String)
data class MonitorSoundDisplayRequest(val width: Int, val height: Int, val refreshRate: Double, val colorDepth: Int, val soundOutput: String, val volume: Int)