package com.hmv.chatbotservice.domain.entity

import java.time.LocalDateTime

data class ProtocolHistoric (
        val id: String,
        val protocol: String,
        val data : String,
        val dateTime: LocalDateTime
)