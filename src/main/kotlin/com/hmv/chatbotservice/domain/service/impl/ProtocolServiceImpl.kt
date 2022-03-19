package com.hmv.chatbotservice.domain.service.impl

import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.repository.ProtocolRepository
import com.hmv.chatbotservice.domain.service.ProtocolService
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class ProtocolServiceImpl(
        private val protocolRepository: ProtocolRepository
): ProtocolService {
    override fun generateProtocol(protocol:Protocol): Protocol {
       return protocolRepository.generateProtocol(protocol)
    }


}