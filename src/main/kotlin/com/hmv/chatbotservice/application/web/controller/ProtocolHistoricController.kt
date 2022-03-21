package com.hmv.chatbotservice.application.web.controller

import com.hmv.chatbotservice.application.web.request.ProtocolHistoryRequest
import com.hmv.chatbotservice.application.web.request.toProtocolHistory
import com.hmv.chatbotservice.application.web.response.StatusResponse
import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
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
    fun postProtocolHistoric(@RequestBody protocolHistoryRequest: ProtocolHistoryRequest): ResponseEntity<StatusResponse> {
        return try {
            val protocolHistoric = protocolHistoricService.save(protocolHistoryRequest.toProtocolHistory())
            ResponseEntity.ok(StatusResponse(protocolHistoric.protocol,"Mensagem salva com sucesso!", 200))
        }catch (ex:Exception){
            ResponseEntity
                    .badRequest()
                    .body(StatusResponse("0","Falha ao salvar mensagem!", -1))
        }

    }

    @GetMapping("/{protocol}")
    fun findByProtocol(@PathVariable protocol:String):ResponseEntity<List<ProtocolHistoric>>{
        return try {
            val response = protocolHistoricService.findByProtocol(listOf(protocol))
            ResponseEntity.ok(response)
        }catch (ex: Exception){
            ResponseEntity.notFound().build()
        }
    }
}