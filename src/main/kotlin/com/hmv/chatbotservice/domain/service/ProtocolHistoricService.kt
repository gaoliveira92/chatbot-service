package com.hmv.chatbotservice.domain.service

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric

interface ProtocolHistoricService {
    fun save(protocolHistoric: ProtocolHistoric): ProtocolHistoric
}