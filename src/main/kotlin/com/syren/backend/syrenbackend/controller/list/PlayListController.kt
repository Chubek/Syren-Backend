package com.syren.backend.syrenbackend.controller.list

import com.syren.backend.syrenbackend.model.list.PlayList
import com.syren.backend.syrenbackend.model.stream.Stream
import com.syren.backend.syrenbackend.service.list.PlayListService
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.service.stream.OverrideMessageService
import com.syren.backend.syrenbackend.subschema.requestobjects.ResourceId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*


@Controller
@RequestMapping("/playList")
class PlayListController {

    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @Autowired
    private lateinit var playListService: PlayListService


    @PostMapping("/create")
    @ResponseBody
    fun createPlayList(@RequestHeader("x-auth-token") token: String, @RequestBody resourceId: ResourceId): String {

        val id = playListService.createPlayList(resourceId.resourceIds.toMutableList())

        val moderatorId = jwtComponent.decodeJwt(token)

        ownershipService.addToOwnershipPlayListList(moderatorId, id)
        
        return id

    }

    @PutMapping("/addPlaylist/{id}/{resourceId}")
    @ResponseBody
    fun addToResourceIds(@RequestHeader("x-auth-token") token: String, @PathVariable id: String, @PathVariable resourceId: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.playListsList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        playListService.addToPlayList(id, resourceId)

        return ResponseEntity(HttpStatus.OK)

    }

    @PutMapping("/removePlaylist/{id}/{resourceId}")
    @ResponseBody
    fun removeFromResourceIds(@RequestHeader("x-auth-token") token: String, @PathVariable id: String, @PathVariable resourceId: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.playListsList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        playListService.removeFromPlayList(id, resourceId)

        return ResponseEntity(HttpStatus.OK)

    }

    @GetMapping("/get/{id}")
    @ResponseBody
    fun getStream(@PathVariable id: String): PlayList {

        return playListService.getPlayList(id)
    }


    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteStream(@RequestHeader("x-auth-token") token: String, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.playListsList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        playListService.deletePlayList(id)

        return ResponseEntity(HttpStatus.GONE)

    }

}