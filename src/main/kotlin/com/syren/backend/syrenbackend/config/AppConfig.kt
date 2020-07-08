package com.syren.backend.syrenbackend.config

import org.modelmapper.ModelMapper
import org.modelmapper.convention.NamingConventions
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class AppConfig {

    @Bean
    fun modelMapper(): ModelMapper? {
        val modelMapper = ModelMapper()
        modelMapper.configuration
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE).sourceNamingConvention = NamingConventions.JAVABEANS_MUTATOR
        return modelMapper
    }
}