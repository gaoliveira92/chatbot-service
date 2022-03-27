package com.hmv.chatbotservice.application.controller

import com.hmv.chatbotservice.application.web.controller.ProtocolController
import com.hmv.chatbotservice.domain.service.ProtocolService
import com.hmv.chatbotservice.utils.ProtocolFakeData
import com.hmv.chatbotservice.utils.ProtocolHistoricResponseFakeData
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
class ProtocolControllerTests {

    private  var protocolService: ProtocolService = mockk()

    @BeforeEach
    fun beforeEach(){
        clearAllMocks()
    }

    @Test
    fun `find protocol by cpf succesfully`(){
        val cpf = ProtocolFakeData().get().cpf
        val protocolController = ProtocolController(protocolService)
        every {protocolService.findByCPF(any())} returns ProtocolHistoricResponseFakeData().get()

        Assertions.assertDoesNotThrow{
            protocolController.findByCPF(cpf)
        }
    }

    @Test
    fun `genarate protocol successfully`(){
        val cpf = ProtocolFakeData().get().cpf
        val protocolController = ProtocolController(protocolService)
        every {protocolService.generateProtocol(any())} returns ProtocolFakeData().get()

        Assertions.assertDoesNotThrow{
            protocolController.generateProtocol(cpf)
        }
    }
}