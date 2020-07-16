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
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.stereotype.Component

@Component
@ComponentScan
class DtoMappers {

    @Autowired
    private lateinit var modelMapper: ModelMapper

    fun moderatorMapperDto(moderator: Moderator): ModeratorDto {
        return modelMapper.map(moderator, ModeratorDto::class.java)
    }
    fun mediaResourceMapperDto(mediaResource: MediaResource): MediaResourceDto {
        return modelMapper.map(mediaResource, MediaResourceDto::class.java)
    }

    fun monitorMapperDto(monitor: Monitor): MonitorDto {
        return modelMapper.map(monitor, MonitorDto::class.java)
    }
    fun overrideMessageMapperDto(overrideMessage: OverrideMessage): OverrideMessageDto {
        return modelMapper.map(overrideMessage, OverrideMessageDto::class.java)
    }
    fun overrideResourceMapperDto(overrideResource: OverrideResource): OverrideResourceDto {
        return modelMapper.map(overrideResource, OverrideResourceDto::class.java)
    }
    fun playListMapperDto(playList: PlayList): PlayListDto {
        return modelMapper.map(playList, PlayListDto::class.java)
    }
    fun scheduleMapperDto(schedule: Schedule): ScheduleDto {
        return modelMapper.map(schedule, ScheduleDto::class.java)
    }
    fun streamMapperDto(stream: Stream): StreamDto {
        return modelMapper.map(stream, StreamDto::class.java)
    }

    fun webPageResourceMapperDto(webPageResource: WebPageResource): WebPageResourceDto {
        return modelMapper.map(webPageResource, WebPageResourceDto::class.java)
    }
    fun widgetResourceMapperDto(widgetResource: WidgetResource): WidgetResourceDto {
        return modelMapper.map(widgetResource, WidgetResourceDto::class.java)
    }

    fun monitorMapperEntity(monitorDto: MonitorDto): Monitor {
        return modelMapper.map(monitorDto, Monitor::class.java)
    }
    fun moderatorMapperEntity(moderatorDto: ModeratorDto): Moderator {
        return modelMapper.map(moderatorDto, Moderator::class.java)
    }
    fun overrideMessageMapperEntity(overrideMessageDto: OverrideMessageDto): OverrideMessage {
        return modelMapper.map(overrideMessageDto, OverrideMessage::class.java)
    }
    fun overrideResourceMapperEntity(overrideResourceDto: OverrideResourceDto): OverrideResource {
        return modelMapper.map(overrideResourceDto, OverrideResource::class.java)
    }
    fun playListMapperEntity(playListDto: PlayListDto): PlayList {
        return modelMapper.map(playListDto, PlayList::class.java)
    }
    fun scheduleMapperEntity(scheduleDto: ScheduleDto): Schedule {
        return modelMapper.map(scheduleDto, Schedule::class.java)
    }
    fun streamMapperEntity(streamDto: StreamDto): Stream {
        return modelMapper.map(streamDto, Stream::class.java)
    }
    fun mediaResourceMapperEntity(mediaResourceDto: MediaResourceDto): MediaResource {
        return modelMapper.map(mediaResourceDto, MediaResource::class.java)
    }
    fun webPageResourceMapperEntity(webPageResourceDto: WebPageResourceDto): WebPageResource {
        return modelMapper.map(webPageResourceDto, WebPageResource::class.java)
    }
    fun widgetResourceMapperEntity(widgetResourceDto: WidgetResourceDto): WidgetResource {
        return modelMapper.map(widgetResourceDto, WidgetResource::class.java)
    }


}