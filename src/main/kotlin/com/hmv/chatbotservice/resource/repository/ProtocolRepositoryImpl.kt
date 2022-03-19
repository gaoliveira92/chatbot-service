package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.repository.ProtocolRepository
import com.hmv.chatbotservice.resource.repository.entity.toDomain
import com.hmv.chatbotservice.resource.repository.entity.toEntity
import org.springframework.stereotype.Repository

@Repository
class ProtocolRepositoryImpl(
        private val jpa: ProtocolRepositoryJpa
): ProtocolRepository {
    override fun generateProtocol(protocol :Protocol): Protocol {
        return jpa.save(protocol.toEntity()).toDomain()
    }
}