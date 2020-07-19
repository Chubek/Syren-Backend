package com.syren.backend.syrenbackend.controller.stream

import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.service.stream.StreamService
import com.syren.backend.syrenbackend.subschema.requestobjects.PlayListId
import org.springframework.beans.factory.annotation.Autowired
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

        ownershipService.addToOwnershipStreamList(id)

        return id

    }

}