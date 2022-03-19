package com.hmv.chatbotservice.domain.service.impl

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
import com.hmv.chatbotservice.domain.repository.ProtocolHistoricRepository
import com.hmv.chatbotservice.domain.service.ProtocolHistoricService
import org.springframework.stereotype.Service

@Service
class ProtocolHistoricServiceImpl(
        private val protocolHistoricRepository: ProtocolHistoricRepository
): ProtocolHistoricService {
    override fun save(protocolHistoric: ProtocolHistoric): ProtocolHistoric {
        return protocolHistoricRepository.save(protocolHistoric)
    }
}