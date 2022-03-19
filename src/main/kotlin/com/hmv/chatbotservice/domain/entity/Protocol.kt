package com.hmv.chatbotservice.domain.entity

import com.hmv.chatbotservice.domain.utils.RandonProtocol
import java.time.LocalDateTime


data class Protocol (
        var id: Int = 0,
        var protocol:String = RandonProtocol().protocol(),
        var startDateTime:LocalDateTime = LocalDateTime.now()
)