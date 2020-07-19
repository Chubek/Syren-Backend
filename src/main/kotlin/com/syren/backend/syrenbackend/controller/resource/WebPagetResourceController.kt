package com.syren.backend.syrenbackend.controller.resource

import com.syren.backend.syrenbackend.model.resource.MediaResource
import com.syren.backend.syrenbackend.model.resource.WebPageResource
import com.syren.backend.syrenbackend.service.file.LocalStorageService
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.resource.WebPageResourceService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import org.springframework.http.HttpStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@Controller
@RequestMapping("/webPage")
class WebPagetResourceController {

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
    private lateinit var webPageResourceService: WebPageResourceService


    @PostMapping("/create/{name}")
    @ResponseBody
    fun uploadAndStoreAway(@RequestParam("file") file: MultipartFile, @PathVariable name: String, @RequestHeader("x-auth-token") token: String): String {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        storageService.store(file)
        val id = webPageResourceService.createWebPageResource(file.name)

        ownership.scriptResourcesList.add(id)

        return id
    }

    @PutMapping("/updateName/{id}")
    @ResponseBody
    fun updateWebPage(@RequestParam("file") file: MultipartFile,
                      @PathVariable id: String,
                      @PathVariable name: String, @RequestHeader("x-auth-token") token: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.scriptResourcesList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }

        storageService.store(file)

        webPageResourceService.updateWebPageResource(id, file.name)
        return ResponseEntity(HttpStatus.ACCEPTED)

    }


    @GetMapping("/get/{id}")
    @ResponseBody
    fun getMediaResource(@PathVariable id: String): WebPageResource {

        return webPageResourceService.getWebPageResource(id)

    }
    

    @DeleteMapping("/deleteWebPage/{id}")
    @ResponseBody
    fun deleteWebPageResource(@PathVariable id: String, @RequestHeader("x-auth-token") token: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.scriptResourcesList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)        }

        webPageResourceService.deleteWebPageResource(id)
        return ResponseEntity(HttpStatus.GONE)

    }



}