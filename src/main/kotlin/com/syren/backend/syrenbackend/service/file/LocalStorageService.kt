package com.syren.backend.syrenbackend.service.file

import org.springframework.context.annotation.ComponentScan
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Path
import java.util.stream.Stream

@Component
@ComponentScan
interface LocalStorageService {
    fun init()
    fun store(file: MultipartFile?)
    fun loadAll(): Stream<Path?>?
    fun load(filename: String?): Path?
    fun loadAsResource(filename: String?): Resource?
    fun deleteAll()
}