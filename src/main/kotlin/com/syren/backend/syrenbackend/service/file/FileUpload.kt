package com.syren.backend.syrenbackend.service.file

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Blob
import com.google.cloud.storage.BucketInfo
import com.syren.backend.syrenbackend.service.components.StorageProvider
import org.springframework.web.multipart.MultipartFile
import java.io.IOError


fun uploadToStorage(file: MultipartFile, bucketName: String): Blob {
    try {
        val bucket = StorageProvider.storage.create(BucketInfo.of(bucketName))

        val bytes = file.bytes

        return bucket.create(file.name, bytes)

    } catch (e: IOError) {
        throw e
    }
}