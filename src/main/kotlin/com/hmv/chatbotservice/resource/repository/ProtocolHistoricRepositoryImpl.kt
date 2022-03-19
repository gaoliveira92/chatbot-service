package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
import com.hmv.chatbotservice.domain.repository.ProtocolHistoricRepository
import com.hmv.chatbotservice.resource.repository.entity.toDomain
import com.hmv.chatbotservice.resource.repository.entity.toEntity
import org.springframework.stereotype.Repository

@Repository
class ProtocolHistoricRepositoryImpl (
    private val jpa : ProtocolHistoricRepositoryJpa
):ProtocolHistoricRepository{
    override fun save(protocolHistoric: ProtocolHistoric): ProtocolHistoric {
        return jpa.save(protocolHistoric.toEntity()).toDomain()
    }

}