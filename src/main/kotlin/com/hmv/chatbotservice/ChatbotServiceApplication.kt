package com.hmv.chatbotservice

import com.hmv.chatbotservice.application.config.EnvironmentConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableCaching
@EnableSwagger2
@EnableTransactionManagement
@EnableConfigurationProperties(EnvironmentConfig::class)
@SpringBootApplication
class ChatbotServiceApplication

fun main(args: Array<String>) {
	runApplication<ChatbotServiceApplication>(*args)
}
