package com.hmv.chatbotservice.domain.service

import com.hmv.chatbotservice.domain.repository.ProtocolHistoricRepository
import com.hmv.chatbotservice.domain.repository.ProtocolRepository
import com.hmv.chatbotservice.domain.service.impl.ProtocolHistoricServiceImpl
import com.hmv.chatbotservice.domain.service.impl.ProtocolServiceImpl
import com.hmv.chatbotservice.resource.repository.ProtocolHistoricRepositoryImpl
import com.hmv.chatbotservice.resource.repository.ProtocolHistoricRepositoryJpa
import com.hmv.chatbotservice.resource.repository.ProtocolRepositoryImpl
import com.hmv.chatbotservice.resource.repository.ProtocolRepositoryJpa
import com.hmv.chatbotservice.utils.ProtocolFakeData
import com.hmv.chatbotservice.utils.ProtocolHistoricFakeData
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProtocolServiceTests {

    private  var protocolRepository: ProtocolRepository = mockk()

    private  var protocolHistoricRepository: ProtocolHistoricRepository = mockk()

    @BeforeEach
    fun beforeEach(){
        clearAllMocks()
    }

    @Test
    fun `find procotol by cpf succesfully`(){
        val protocolHistoricService = ProtocolHistoricServiceImpl(protocolHistoricRepository)
        var protocolService = ProtocolServiceImpl(protocolHistoricService,protocolRepository)
        every { protocolRepository.findByCPF(any())} returns listOf(ProtocolFakeData().get())
        every { protocolHistoricRepository.findByProtocol(any())} returns ProtocolHistoricFakeData().getList()

        val result = protocolService.findByCPF("32036748932")

        Assertions.assertEquals(3, result.protocolHistoric.size)
    }
}