package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.resource.repository.entity.ProtocolEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


interface ProtocolRepositoryJpa : CrudRepository<ProtocolEntity, Int>
