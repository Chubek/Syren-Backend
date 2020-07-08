package com.syren.backend.syrenbackend.service.file

import com.google.cloud.storage.Blob
import com.google.cloud.storage.BlobId
import com.google.cloud.storage.Bucket
import com.syren.backend.syrenbackend.service.components.StorageProvider

fun readFromStorage(blobId: BlobId): Blob {
    return StorageProvider.storage.get(blobId)
}