package com.hmv.chatbotservice.application.controller

import com.hmv.chatbotservice.application.web.controller.ProtocolController
import com.hmv.chatbotservice.application.web.controller.ProtocolHistoricController
import com.hmv.chatbotservice.application.web.request.toProtocolHistory
import com.hmv.chatbotservice.domain.service.ProtocolHistoricService
import com.hmv.chatbotservice.domain.service.ProtocolService
import com.hmv.chatbotservice.utils.ProtocolFakeData
import com.hmv.chatbotservice.utils.ProtocolHistoricFakeData
import com.hmv.chatbotservice.utils.ProtocolHistoricRequestFakeData
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
class ProtocolHistoricControllerTests {
    private  var protocolHistoricService: ProtocolHistoricService = mockk()

    @BeforeEach
    fun beforeEach(){
        clearAllMocks()
    }

    @Test
    fun `find historic by protocol succesfully`(){
        val protocol = ProtocolFakeData().get().protocol
        val protocolController = ProtocolHistoricController(protocolHistoricService)
        every {protocolHistoricService.findByProtocol(any())} returns ProtocolHistoricFakeData().getList()

        Assertions.assertDoesNotThrow{
            protocolController.findByProtocol(protocol)
        }
    }

    @Test
    fun `save historic protocol succesfully`(){
        val protocolHistoricRequest = ProtocolHistoricRequestFakeData().get()
        val protocolController = ProtocolHistoricController(protocolHistoricService)
        every {protocolHistoricService.save(any())} returns ProtocolHistoricFakeData().get()

        Assertions.assertDoesNotThrow{
            protocolController.postProtocolHistoric(protocolHistoricRequest)
        }
    }
}