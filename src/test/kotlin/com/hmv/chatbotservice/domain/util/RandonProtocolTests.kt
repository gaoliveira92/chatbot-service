package com.hmv.chatbotservice.domain.util

import com.hmv.chatbotservice.domain.utils.RandonProtocol
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RandonProtocolTests {

    @Test
    fun `should return a new protocol`(){
        val newProtocol = RandonProtocol().protocol()
        Assertions.assertNotNull(newProtocol)
    }
}