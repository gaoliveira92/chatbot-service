package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.resource.repository.entity.ProtocolEntity
import com.hmv.chatbotservice.resource.repository.entity.ProtocolHistoricEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ProtocolHistoricRepositoryJpa : CrudRepository<ProtocolHistoricEntity, Int> {

    @Query("SELECT p FROM ProtocolHistoricEntity p WHERE p.protocol in ( :protocolList )")
    fun findAllByProtocol(protocolList: List<String>): List<ProtocolHistoricEntity>?
}