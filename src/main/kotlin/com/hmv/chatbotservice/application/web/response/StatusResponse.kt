package com.hmv.chatbotservice.application.web.response

data class StatusResponse (
        val protocol: String,
        val message: String,
        val code: Int
)