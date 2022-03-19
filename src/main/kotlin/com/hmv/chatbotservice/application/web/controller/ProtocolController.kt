package com.hmv.chatbotservice.application.web.controller

import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.service.ProtocolService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("protocol/new")
class ProtocolController(
        private val protocolService: ProtocolService
) {

    @GetMapping("/{cpf}")
    fun generateProtocol(@PathVariable cpf:String):ResponseEntity<String>{
        var newProtocol = Protocol(cpf = cpf)
        val response = protocolService.generateProtocol(newProtocol)
        return ResponseEntity.ok(response.protocol)
    }

}