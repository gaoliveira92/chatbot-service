package com.hmv.chatbotservice.domain.service.impl

import com.hmv.chatbotservice.application.web.response.ProtocolHistoricResponse
import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
import com.hmv.chatbotservice.domain.repository.ProtocolRepository
import com.hmv.chatbotservice.domain.service.ProtocolHistoricService
import com.hmv.chatbotservice.domain.service.ProtocolService
import org.springframework.stereotype.Service

@Service
class ProtocolServiceImpl(
        private val protocolHistoricService: ProtocolHistoricService,
        private val protocolRepository: ProtocolRepository
): ProtocolService {
    override fun generateProtocol(protocol:Protocol): Protocol {
       return protocolRepository.generateProtocol(protocol)
    }

    override fun findByCPF(cpf: String): ProtocolHistoricResponse {
        var protocolHistoricList = mutableListOf<ProtocolHistoric>()
        val protocolList = protocolRepository.findByCPF(cpf)
        if (!protocolList.isNullOrEmpty())
            protocolHistoricList = protocolHistoricService.findByProtocol(protocolList.map{it.protocol}).toMutableList()
        return ProtocolHistoricResponse(cpf,protocolHistoricList)
    }


}