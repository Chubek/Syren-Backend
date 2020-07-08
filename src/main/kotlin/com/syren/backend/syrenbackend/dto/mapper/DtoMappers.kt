package com.syren.backend.syrenbackend.dto.mapper

import com.syren.backend.syrenbackend.dto.modeldataclass.*
import com.syren.backend.syrenbackend.model.display.Monitor
import com.syren.backend.syrenbackend.model.list.PlayList
import com.syren.backend.syrenbackend.model.list.Schedule
import com.syren.backend.syrenbackend.model.moderator.Moderator
import com.syren.backend.syrenbackend.model.resource.*
import com.syren.backend.syrenbackend.model.stream.OverrideMessage
import com.syren.backend.syrenbackend.model.stream.OverrideResource
import com.syren.backend.syrenbackend.model.stream.Stream
import org.modelmapper.ModelMapper

fun monitorDtoMapper(monitor: Monitor) {
    return ModelMapper().map(monitor, MonitorDto::class)
}

fun playListDtoMapper(playList: PlayList) {
    return ModelMapper().map(playList, PlayListDto::class)
}

fun scheduleDtoMapper(schedule: Schedule) {
    return ModelMapper().map(schedule, ScheduleDto::class)
}

fun moderatorDtoMapper(moderator: Moderator) {
    return ModelMapper().map(moderator, ModeratorDto::class)
}

fun audioResourceDtoMapper(audioResource: AudioResource) {
    return ModelMapper().map(audioResource, AudioResourceDto::class)
}

fun imageResourceDtoMapper(imageResource: ImageResource) {
    return ModelMapper().map(imageResource, ImageResourceDto::class)
}

fun videoResourceDtoMapper(videoResource: VideoResource) {
    return ModelMapper().map(videoResource, VideoResourceDto::class)
}

fun webPageResourceDtoMapper(webPageResource: WebPageResource) {
    return ModelMapper().map(webPageResource, WebPageResourceDto::class)
}

fun widgetResourceDtoMapper(widgetResource: WidgetResource) {
    return ModelMapper().map(widgetResource, WidgetResourceDto::class)
}

fun overrideMessageDtoMapper(overrideMessage: OverrideMessage) {
    return ModelMapper().map(overrideMessage, OverrideMessageDto::class)
}

fun overrideResourceDtoMapper(overrideResource: OverrideResource) {
    return ModelMapper().map(overrideResource, OverrideResourceDto::class)
}

fun streamDtoMapper(stream: Stream) {
    return ModelMapper().map(stream, StreamDto::class)
}