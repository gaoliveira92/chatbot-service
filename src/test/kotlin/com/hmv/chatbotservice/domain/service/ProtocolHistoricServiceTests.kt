package com.hmv.chatbotservice.domain.service

import com.hmv.chatbotservice.domain.repository.ProtocolHistoricRepository
import com.hmv.chatbotservice.domain.service.impl.ProtocolHistoricServiceImpl
import com.hmv.chatbotservice.utils.ProtocolHistoricFakeData
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProtocolHistoricServiceTests {
    private  var protocolHistoricRepository: ProtocolHistoricRepository = mockk()

    @BeforeEach
    fun beforeEach(){
        clearAllMocks()
    }

    @Test
    fun `find historic by protocol succesfully`(){
        val protocol = ProtocolHistoricFakeData().get().protocol
        val protocolHistoricService = ProtocolHistoricServiceImpl(protocolHistoricRepository)
        every { protocolHistoricRepository.findByProtocol(any())} returns ProtocolHistoricFakeData().getList()

        val result = protocolHistoricService.findByProtocol(listOf(protocol))

        Assertions.assertEquals(3, result.size)
    }

    @Test
    fun `should not find historic by protocol`(){
        val protocol = ProtocolHistoricFakeData().get().protocol
        val protocolHistoricService = ProtocolHistoricServiceImpl(protocolHistoricRepository)
        every { protocolHistoricRepository.findByProtocol(any())} returns listOf()

        val result = protocolHistoricService.findByProtocol(listOf(protocol))

        Assertions.assertEquals(0, result.size)
    }

    @Test
    fun `save historic protocol successfully`(){
        val protocol = ProtocolHistoricFakeData().get()
        val protocolHistoricService = ProtocolHistoricServiceImpl(protocolHistoricRepository)
        every { protocolHistoricRepository.save(any())} returns protocol

        val result = protocolHistoricService.save(protocol)

        Assertions.assertEquals(protocol.id, result.id)
        Assertions.assertEquals(protocol.data, result.data)
    }

}