package com.syren.backend.syrenbackend.controller.stream

import com.syren.backend.syrenbackend.model.stream.OverrideMessage
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.service.stream.OverrideMessageService
import com.syren.backend.syrenbackend.service.stream.StreamService
import com.syren.backend.syrenbackend.subschema.requestobjects.Message
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/overrideMessage")
class OverrideMessageController {

    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @Autowired
    private lateinit var overrideMessageService: OverrideMessageService

    @PostMapping("/create/{messageId}")
    @ResponseBody
    fun createOverrideMessage(@RequestHeader("x-auth-token") token: String, @RequestBody message: Message): String {

        val id = overrideMessageService.createOverrideMessage(message.message)

        val moderatorId = jwtComponent.decodeJwt(token)

        ownershipService.addToOwnershipOverrideMessageList(moderatorId, id)

        return id

    }

    @PutMapping("/update/{id}")
    @ResponseBody
    fun updateOverrideMessage(@RequestHeader("x-auth-token") token: String, @PathVariable message: Message, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.overrideMessagesList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        overrideMessageService.updateOverrideMessage(id, message.message)

        return ResponseEntity(HttpStatus.ACCEPTED)

    }

    @GetMapping("/get/{id}")
    @ResponseBody
    fun getOverrideMessage(@PathVariable id: String): OverrideMessage {

        return overrideMessageService.getOverrideMessage(id)

    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteOverrideMessage(@RequestHeader("x-auth-token") token: String, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.overrideMessagesList.contains(id)) {

            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        overrideMessageService.deleteOverrideMessage(id)

        return ResponseEntity(HttpStatus.GONE)

    }


}