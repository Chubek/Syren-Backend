package com.syren.backend.syrenbackend.controller.resource

import com.syren.backend.syrenbackend.service.resource.MediaResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/resource/media")
class MediaResourceController {

    @Autowired
    private lateinit var mediaResourceService: MediaResourceService



}