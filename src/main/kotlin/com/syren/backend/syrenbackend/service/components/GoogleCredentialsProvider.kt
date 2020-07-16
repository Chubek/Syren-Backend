package com.syren.backend.syrenbackend.service.components

import com.google.auth.oauth2.GoogleCredentials
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.FileInputStream

@Component
class GoogleCredentialsProvider {

    companion object {
        @Value("\${googleAppCredFile}")
        private lateinit var googleAppCredFile: String

        private val credentialsStream = FileInputStream(googleAppCredFile)

        val credentials = GoogleCredentials.fromStream(credentialsStream)


    }


}