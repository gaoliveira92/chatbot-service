package com.hmv.chatbotservice.domain.repository

import com.hmv.chatbotservice.domain.entity.Protocol
import java.time.LocalDateTime

interface ProtocolRepository {
    fun generateProtocol(protocol: Protocol): Protocol
}