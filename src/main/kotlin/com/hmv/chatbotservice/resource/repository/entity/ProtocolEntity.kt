package com.hmv.chatbotservice.resource.repository.entity

import com.hmv.chatbotservice.domain.entity.Protocol
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="protocol")
data class ProtocolEntity (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int,
        val protocol:String = id.toString() + LocalDate.now().toString(),
        @Column(name="start_date_time")
        val startDateTime: LocalDateTime
)

fun ProtocolEntity.toDomain() = Protocol(
        id = id,
        protocol = protocol,
        startDateTime = startDateTime
)

fun Protocol.toEntity() = ProtocolEntity(
        id = id,
        protocol = protocol,
        startDateTime = startDateTime
)