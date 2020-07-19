package com.syren.backend.syrenbackend.controller.resource

import com.syren.backend.syrenbackend.model.resource.WidgetResource
import com.syren.backend.syrenbackend.service.file.LocalStorageService
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.resource.WidgetResourceService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import org.springframework.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@Controller
@RequestMapping("/widget")
class WidgetResourceController {

    private lateinit var storageService: LocalStorageService

    @Autowired
    fun constructor(storageService: LocalStorageService) {
        this.storageService = storageService
    }

    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @Autowired
    private lateinit var widgetResourceService: WidgetResourceService


    @PostMapping("/create/{name}")
    @ResponseBody
    fun uploadAndStoreAway(@RequestParam("file") file: MultipartFile, @PathVariable name: String): String {

        storageService.store(file)
        return widgetResourceService.createWidgetResource(file.name, name)

    }

    @PutMapping("/updateName/{id}/{newName}")
    @ResponseBody
    fun updateWidgetName(@PathVariable id: String, @PathVariable newName: String,
                         @RequestHeader("x-auth-token") token: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.scriptResourcesList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        widgetResourceService.updateWidgetResourceName(id, newName)
        return ResponseEntity(HttpStatus.ACCEPTED)

    }

    @DeleteMapping("/deleteWidget/{id}")
    @ResponseBody
    fun deleteWidgetResource(@PathVariable id: String): ResponseEntity<String> {

        widgetResourceService.deleteWidgetResource(id)
        return ResponseEntity(HttpStatus.GONE)

    }



}