package com.syren.backend.syrenbackend.controller.stream

import com.syren.backend.syrenbackend.model.stream.OverrideResource
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.service.stream.OverrideResourceService
import com.syren.backend.syrenbackend.service.stream.StreamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/overrideResource")
class OverrideResourceController {

    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @Autowired
    private lateinit var overrideResourceService: OverrideResourceService

    @PostMapping("/create/{resourceId}")
    @ResponseBody
    fun createOverrideResource(@RequestHeader("x-auth-token") token: String, @PathVariable resourceId: String): String {

        val id = overrideResourceService.createOverrideResource(resourceId)

        val moderatorId = jwtComponent.decodeJwt(token)

        ownershipService.addToOwnershipOverrideResourceList(moderatorId, id)

        return id

    }

    @PutMapping("/update/{id}/{resourceId}")
    @ResponseBody
    fun updateOverrideResource(@RequestHeader("x-auth-token") token: String, @PathVariable resourceId: String, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.overrideResourcesList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        overrideResourceService.updateOverrideResource(id, resourceId)

        return ResponseEntity(HttpStatus.ACCEPTED)

    }

    @GetMapping("/get/{id}")
    @ResponseBody
    fun getOverrideResource(@PathVariable id: String): OverrideResource {

        return overrideResourceService.getOverrideResource(id)

    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    fun deleteOverrideResource(@RequestHeader("x-auth-token") token: String, @PathVariable id: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.overrideResourcesList.contains(id)) {

            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        overrideResourceService.deleteOverrideResource(id)

        return ResponseEntity(HttpStatus.GONE)

    }


}