package com.syren.backend.syrenbackend.config

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.auth0.jwt.exceptions.JWTCreationException
import com.auth0.jwt.exceptions.JWTVerificationException
import org.modelmapper.ModelMapper
import org.modelmapper.convention.NamingConventions
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

import org.springframework.security.crypto.password.PasswordEncoder





@Configuration
@ComponentScan
class AppConfig {

    @Bean
    fun modelMapper(): ModelMapper? {
        val modelMapper = ModelMapper()
        modelMapper.configuration
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).sourceNamingConvention = NamingConventions.JAVABEANS_MUTATOR
        return modelMapper
    }

    @Value("\${jwtSecret}")
    private lateinit var jwtSecret: String

    @Bean
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

    @Bean
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


    @Bean
    fun passwordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

}