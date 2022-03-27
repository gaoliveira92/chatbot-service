package com.hmv.chatbotservice.resource.repository

import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.repository.ProtocolRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import javax.transaction.Transactional


@SpringBootTest
@Transactional
class ProtocolRepositoryTests {
    @Autowired
    private lateinit var protocolRepository: ProtocolRepository

    @Test
    fun `insert new protocol successfully`(){
        val protocol = Protocol(cpf = "32036748932")
        val result = protocolRepository.generateProtocol(protocol)
        Assertions.assertEquals("32036748932",result.cpf)
    }

    @Test
    fun `find by cpf successfully`(){
        val cpf = "32036748932"
        val result = protocolRepository.findByCPF(cpf)
        Assertions.assertEquals(3,result.size)
    }

    @Test
    fun `not find by cpf`(){
        val cpf = "000000000"
        val result = protocolRepository.findByCPF(cpf)
        Assertions.assertEquals(0,result.size)
    }
}