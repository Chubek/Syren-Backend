package com.syren.backend.syrenbackend.messaging

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import org.springframework.web.util.HtmlUtils


@Controller
class Websockets {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    @Throws(Exception::class)
    fun greeting(message: HelloMessage): Greeting? {
        Thread.sleep(1000) // simulated delay
        return Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!")
    }

}