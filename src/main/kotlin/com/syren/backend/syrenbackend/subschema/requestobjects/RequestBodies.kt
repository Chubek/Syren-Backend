package com.syren.backend.syrenbackend.subschema.requestobjects

import com.syren.backend.syrenbackend.subschema.dataclass.NotificationAlert
import com.syren.backend.syrenbackend.subschema.dataclass.ScheduleDate
import java.util.*

data class BucketName(val bucketName: String, val fileType: String)
data class PlayListId(val playListIds: List<String>)
data class Message(val message: NotificationAlert)
data class ResourceId(val resourceIds: List<String>)
data class ScheduleRequestBody(val streamId: String, val scheduleDates: List<ScheduleDate>)
data class ScheduleDate(val scheduleDate: ScheduleDate)
data class StreamId(val streamId: String)