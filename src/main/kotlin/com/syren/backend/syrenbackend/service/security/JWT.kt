package com.syren.backend.syrenbackend.service.security

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class JWT {

    @Value("\${jwtSecret}")
    private lateinit var jwtSecret: String

    fun createJwt(subject: String): String {
        try {

            val algorithm = Algorithm.HMAC256(jwtSecret)

            return JWT.create()
                    .withSubject(subject)
                    .withIssuer("auth0")
                    .sign(algorithm)
        } catch (e: JWTCreationException) {
            throw e
        }
    }

    fun decodeJwt(jwt: String): String {
        try {
            val algorithm = Algorithm.HMAC256(jwtSecret)

            val verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build()

            return verifier.verify(jwt).toString()
        } catch (e: JWTVerificationException) {
            throw e
        }
    }


}