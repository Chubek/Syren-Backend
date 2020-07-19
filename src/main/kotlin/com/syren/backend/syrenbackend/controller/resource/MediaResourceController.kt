package com.syren.backend.syrenbackend.controller.resource

import com.auth0.jwt.JWT
import com.syren.backend.syrenbackend.exception.NotOwnerException
import com.syren.backend.syrenbackend.model.resource.MediaResource
import com.syren.backend.syrenbackend.service.file.uploadToStorage
import com.syren.backend.syrenbackend.service.ownership.OwnershipService
import com.syren.backend.syrenbackend.service.resource.MediaResourceService
import com.syren.backend.syrenbackend.service.security.JWTComponent
import com.syren.backend.syrenbackend.subschema.requestobjects.BucketName
import com.syren.backend.syrenbackend.subschema.requestobjects.IdContainer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/resource/media")
class MediaResourceController {

    @Autowired
    private lateinit var mediaResourceService: MediaResourceService

    @Autowired
    private lateinit var ownershipService: OwnershipService

    @Autowired
    private lateinit var jwtComponent: JWTComponent

    @PostMapping("/upload/")
    @ResponseBody
    fun uploadFileToCloud(@RequestParam("file") file: MultipartFile, @RequestBody bucketName: BucketName,
                            @RequestHeader("x-auth-token") token: String): String {
        uploadToStorage(file, bucketName.bucketName)

        val id = mediaResourceService.createMediaResource(file.name, bucketName.fileType, bucketName.bucketName)

        val userId = jwtComponent.decodeJwt(token)

        ownershipService.addToOwnershipMediaList(userId, id)

        return id
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    fun getMediaResource(@PathVariable id: String): MediaResource {

        return mediaResourceService.getMediaResource(id)

    }

    @DeleteMapping("/delete/{id}")
    fun deleteMediaResource(@PathVariable id: String, @RequestHeader("x-auth-token") token: String): ResponseEntity<String> {

        val moderatorId = jwtComponent.decodeJwt(token)

        val ownership = ownershipService.getOwnership(moderatorId)

        if (!ownership.mediaResourcesList.contains(id)) {
            return ResponseEntity(HttpStatus.FORBIDDEN)
        }


        mediaResourceService.deleteMediaResource(id)

        return ResponseEntity(HttpStatus.GONE)

    }




}