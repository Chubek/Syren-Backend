package com.syren.backend.syrenbackend.service.components

import com.google.cloud.storage.StorageOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class StorageProvider {
    companion object {

        @Value("\${projectId}")
        private lateinit var projectId: String

        var storage = StorageOptions.newBuilder().setCredentials(GoogleCredentialsProvider.credentials)
                .setProjectId(projectId).build().service
    }
}