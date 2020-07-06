package com.syren.backen.syrenbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SyrenServiceApplication

fun main(args: Array<String>) {
    runApplication<SyrenServiceApplication>(*args)
}
