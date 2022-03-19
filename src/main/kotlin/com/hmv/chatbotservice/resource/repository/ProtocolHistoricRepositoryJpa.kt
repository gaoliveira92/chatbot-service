package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.resource.repository.entity.ProtocolEntity
import com.hmv.chatbotservice.resource.repository.entity.ProtocolHistoricEntity
import org.springframework.data.repository.CrudRepository

interface ProtocolHistoricRepositoryJpa : CrudRepository<ProtocolHistoricEntity, Int>