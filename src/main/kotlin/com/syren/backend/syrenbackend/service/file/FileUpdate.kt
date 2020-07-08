package com.syren.backend.syrenbackend.service.file

import com.google.cloud.storage.Blob
import com.google.cloud.storage.BlobId
import com.syren.backend.syrenbackend.service.components.StorageProvider
import org.springframework.web.multipart.MultipartFile
import java.nio.ByteBuffer

fun updateFileInStorage(newFile: MultipartFile, blobId: BlobId) {
    val newBytes = newFile.bytes

    val blob: Blob = StorageProvider.storage.get(blobId)

    val channel = blob.writer()
    channel.write(ByteBuffer.wrap(newBytes))
    channel.close()
}