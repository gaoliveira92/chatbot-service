package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.resource.repository.entity.ProtocolEntity
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


interface ProtocolRepositoryJpa : CrudRepository<ProtocolEntity, Int> {

    @Query("SELECT p FROM ProtocolEntity p WHERE p.cpf = :cpf")
    fun findByCPF(cpf: String): List<ProtocolEntity>?
}
