package com.syren.backend.syrenbackend.controller.stream

import com.syren.backend.syrenbackend.model.stream.Stream
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.service.stream.StreamService
import com.syren.backend.syrenbackend.subschema.requestobjects.PlayListId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/stream")
class StreamController {

    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @Autowired
    private lateinit var streamService: StreamService

    @PostMapping("/create")
    @ResponseBody
    fun createStream(@RequestHeader("x-auth-token") token: String, @RequestBody playListId: PlayListId): String {

        val moderatorId = jwtComponent.decodeJwt(token)

        val id = streamService.createStream(playListId.playListIds.toMutableList(), "")

        ownershipService.addToOwnershipStreamList(moderatorId, id)

        return id

    }

    @GetMapping("/get/{id}")
    @ResponseBody
    fun getStream(@PathVariable id: String): Stream {

        return streamService.getStream(id)
    }

    @PutMapping("/addPlaylist/{id}/{playListId}")
    @ResponseBody
    fun addToPlayListIds(@RequestHeader("x-auth-token") token: String, @PathVariable id: String, @PathVariable playListId: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.streamsList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        streamService.addToPlayListIds(id, playListId)

        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/removePlaylist/{id}/{playListId}")
    @ResponseBody
    fun removeFromPlayListIds(@RequestHeader("x-auth-token") token: String, @PathVariable id: String, @PathVariable playListId: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.streamsList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        streamService.removeFromPlayListIds(id, playListId)

        return ResponseEntity(HttpStatus.OK)

    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteStream(@RequestHeader("x-auth-token") token: String, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.streamsList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        streamService.deleteStream(id)

        return ResponseEntity(HttpStatus.GONE)

    }

}