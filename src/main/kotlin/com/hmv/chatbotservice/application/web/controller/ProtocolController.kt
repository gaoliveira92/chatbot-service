package com.hmv.chatbotservice.application.web.controller

import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.service.ProtocolService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("protocol/new")
class ProtocolController(
        private val protocolService: ProtocolService
) {

    @GetMapping
    fun generateProtocol():ResponseEntity<String>{
        var newProtocol = Protocol()
        val response = protocolService.generateProtocol(newProtocol)
        return ResponseEntity.ok(response.protocol)
    }

}