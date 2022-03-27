package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
import com.hmv.chatbotservice.domain.repository.ProtocolHistoricRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import javax.transaction.Transactional

@SpringBootTest
@Transactional
class ProtocolHistoricRepositoryTests {

    @Autowired
    private lateinit var protocolHistoricRepository: ProtocolHistoricRepository

    @Test
    fun `save protocol historic successfully`(){
        val protocolHistoric = ProtocolHistoric(
                "id1",
                "552820220321T000224735792",
                "data",
                LocalDateTime.now()
        )
        val result = protocolHistoricRepository.save(protocolHistoric)

        Assertions.assertEquals(protocolHistoric.id, result.id)
    }

    @Test
    fun `find by protocol successfully`(){
        val protocolHistoric = protocolHistoricRepository.findByProtocol(listOf("552820220321T000224735792"))
        Assertions.assertEquals(1, protocolHistoric.size)
    }

    @Test
    fun `not found historic by protocol`(){
        val protocolHistoric = protocolHistoricRepository.findByProtocol(listOf("552T000224735792"))
        Assertions.assertEquals(0, protocolHistoric.size)
    }
}