package com.syren.backend.syrenbackend.controller.list

import com.syren.backend.syrenbackend.model.list.Schedule
import com.syren.backend.syrenbackend.model.stream.Stream
import com.syren.backend.syrenbackend.service.list.ScheduleService
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.service.stream.OverrideMessageService
import com.syren.backend.syrenbackend.subschema.requestobjects.ResourceId
import com.syren.backend.syrenbackend.subschema.requestobjects.ScheduleDate
import com.syren.backend.syrenbackend.subschema.requestobjects.ScheduleRequestBody
import com.syren.backend.syrenbackend.subschema.requestobjects.StreamId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/schedule")
class ScheduleController {

    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @Autowired
    private lateinit var scheduleService: ScheduleService


    @PostMapping("/create")
    @ResponseBody
    fun createSchedule(@RequestHeader("x-auth-token") token: String, @RequestBody scheduleRequestBody: ScheduleRequestBody): String {

        val id = scheduleService.createSchedule(scheduleRequestBody.streamId, scheduleRequestBody.scheduleDates.toMutableList())

        val moderatorId = jwtComponent.decodeJwt(token)

        ownershipService.addToOwnershipScheduleList(moderatorId, id)
        
        return id

    }

    @PutMapping("/addPDate/{id}")
    @ResponseBody
    fun addToDateToSchedule(@RequestHeader("x-auth-token") token: String, @PathVariable id: String, @RequestBody scheduleDate: ScheduleDate): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.scheduleLists.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        scheduleService.addDateToSchedule(id, scheduleDate.scheduleDate)

        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/removeDate/{id}")
    @ResponseBody
    fun removeFromResourceIds(@RequestHeader("x-auth-token") token: String, @PathVariable id: String, @RequestBody scheduleDate: ScheduleDate) : ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.scheduleLists.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        scheduleService.removeDateFromSchedule(id, scheduleDate.scheduleDate)

        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/editStreamId/{id}")
    @ResponseBody
    fun removeFromResourceIds(@RequestHeader("x-auth-token") token: String, @PathVariable id: String, @RequestBody streamId: StreamId) : ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.scheduleLists.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        scheduleService.editStreamId(id, streamId.streamId)

        return ResponseEntity(HttpStatus.OK)

    }

    @GetMapping("/get/{id}")
    @ResponseBody
    fun getStream(@PathVariable id: String): Schedule {

        return scheduleService.getSchedule(id)
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteStream(@RequestHeader("x-auth-token") token: String, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.scheduleLists.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        scheduleService.deleteSchedule(id)

        return ResponseEntity(HttpStatus.GONE)

    }

}