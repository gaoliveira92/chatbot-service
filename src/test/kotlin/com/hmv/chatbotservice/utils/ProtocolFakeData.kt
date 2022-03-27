package com.hmv.chatbotservice.utils

import com.hmv.chatbotservice.domain.entity.Protocol
import java.time.LocalDateTime

class ProtocolFakeData {
    fun get() = Protocol(
            "protocol1",
            "32036748932",
            LocalDateTime.now()
    )
}