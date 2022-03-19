package com.hmv.chatbotservice.resource.repository.entity

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name="protocol_historic")
data class ProtocolHistoricEntity(
        @Id
        val id: String,
        val protocol:String,
        val data: String,
        @Column(name="date_time")
        val dateTime: LocalDateTime
)

fun ProtocolHistoric.toEntity() = ProtocolHistoricEntity(
        id = id,
        protocol = protocol,
        data = data,
        dateTime = dateTime
)

fun ProtocolHistoricEntity.toDomain() = ProtocolHistoric(
        id = id,
        protocol = protocol,
        data = data,
        dateTime = dateTime
)
