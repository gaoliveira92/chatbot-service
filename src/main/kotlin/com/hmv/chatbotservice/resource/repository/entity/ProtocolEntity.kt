package com.hmv.chatbotservice.resource.repository.entity

import com.hmv.chatbotservice.domain.entity.Protocol
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="protocol")
data class ProtocolEntity (
        @Id
        @Column(name="protocol_id")
        val protocol:String,
        val cpf: String,
        @Column(name="start_date_time")
        val startDateTime: LocalDateTime
)

fun ProtocolEntity.toDomain() = Protocol(
        protocol = protocol,
        cpf = cpf,
        startDateTime = startDateTime
)

fun Protocol.toEntity() = ProtocolEntity(
        protocol = protocol,
        cpf = cpf,
        startDateTime = startDateTime
)