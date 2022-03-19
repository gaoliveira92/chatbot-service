package com.hmv.chatbotservice.application.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class EnvironmentConfig {

    @Value("\${config.services.user}")
    lateinit var user : String

    @Value("\${config.services.password}")
    lateinit var password : String

    @Value("\${config.services.role}")
    lateinit var role : String
}