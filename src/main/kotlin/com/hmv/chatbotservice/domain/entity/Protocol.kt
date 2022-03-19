package com.hmv.chatbotservice.domain.entity

import com.hmv.chatbotservice.domain.utils.RandonProtocol
import java.time.LocalDateTime


data class Protocol (
        var protocol:String = RandonProtocol().protocol(),
        var cpf: String,
        var startDateTime:LocalDateTime = LocalDateTime.now()
)