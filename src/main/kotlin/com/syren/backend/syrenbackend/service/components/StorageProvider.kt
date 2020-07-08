package com.syren.backend.syrenbackend.service.components

import com.google.cloud.storage.StorageOptions
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class StorageProvider {
    companion object {

        @Value("\${ProjectId}")
        private lateinit var ProjectId: String

        var storage = StorageOptions.newBuilder().setCredentials(GoogleCredentialsProvider.credentials)
                .setProjectId(ProjectId).build().service
    }
}