package com.syren.backend.syrenbackend.controller.resource

import com.syren.backend.syrenbackend.service.file.uploadToStorage
import com.syren.backend.syrenbackend.service.resource.MediaResourceService
import com.syren.backend.syrenbackend.subschema.requestobjects.BucketName
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

    @PostMapping("/upload/media")
    @ResponseBody
    fun uploadFileToCloud(@RequestParam("file") file: MultipartFile, @RequestBody bucketName: BucketName): ResponseEntity<String> {
        uploadToStorage(file, bucketName.bucketName)

        return ResponseEntity(HttpStatus.OK)
    }





}