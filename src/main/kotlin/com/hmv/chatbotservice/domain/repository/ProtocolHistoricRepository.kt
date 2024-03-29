package com.hmv.chatbotservice.domain.repository

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric

interface ProtocolHistoricRepository {
    fun save(protocolHistoric: ProtocolHistoric):ProtocolHistoric
    fun findByProtocol(protocol: List<String>): List<ProtocolHistoric>
}