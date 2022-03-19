package com.hmv.chatbotservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableCaching
@EnableSwagger2
@SpringBootApplication
class ChatbotServiceApplication

fun main(args: Array<String>) {
	runApplication<ChatbotServiceApplication>(*args)
}
