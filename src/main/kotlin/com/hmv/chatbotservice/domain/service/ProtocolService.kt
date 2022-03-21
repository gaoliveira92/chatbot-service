package com.hmv.chatbotservice.domain.service

import com.hmv.chatbotservice.application.web.response.ProtocolHistoricResponse
import com.hmv.chatbotservice.domain.entity.Protocol

interface ProtocolService {
    fun generateProtocol(protocol: Protocol): Protocol
    fun findByCPF(cpf: String): ProtocolHistoricResponse
}