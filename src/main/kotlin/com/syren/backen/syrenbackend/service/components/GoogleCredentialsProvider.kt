package com.syren.backen.syrenbackend.service.components

import com.google.auth.oauth2.GoogleCredentials
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.io.FileInputStream

@Component
class GoogleCredentialsProvider {

    companion object {
        @Value("\${GoogleAppCredFile}")
        private lateinit var GoogleAppCredFile: String

        private val credentialsStream = FileInputStream(GoogleAppCredFile)

        val credentials = GoogleCredentials.fromStream(credentialsStream)


    }


}