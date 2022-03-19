package com.hmv.chatbotservice.application.web.controller

import com.hmv.chatbotservice.application.web.request.ProtocolHistoryRequest
import com.hmv.chatbotservice.application.web.request.toProtocolHistory
import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.service.ProtocolHistoricService
import org.springframework.context.annotation.Role
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("protocol/historic")
class ProtocolHistoricController(
        private val protocolHistoricService: ProtocolHistoricService
) {
    @PostMapping
    @PreAuthorize("hasAuthority('service')")
    fun postProtocolHistoric(@RequestBody protocolHistoryRequest: ProtocolHistoryRequest): ResponseEntity<Int> {
       try {
           protocolHistoricService.save(protocolHistoryRequest.toProtocolHistory())
           return ResponseEntity.ok(200)
       }catch (ex:Exception){

       }
        return ResponseEntity.ok(400)
    }
}