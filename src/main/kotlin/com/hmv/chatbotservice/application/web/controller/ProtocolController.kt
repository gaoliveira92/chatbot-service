package com.hmv.chatbotservice.application.web.controller

import com.hmv.chatbotservice.application.web.response.ProtocolHistoricResponse
import com.hmv.chatbotservice.application.web.response.StatusResponse
import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.service.ProtocolService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("protocol")
class ProtocolController(
        private val protocolService: ProtocolService
) {

    @GetMapping("/new/{cpf}")
    fun generateProtocol(@PathVariable cpf:String):ResponseEntity<StatusResponse>{
        return try {
            val newProtocol = Protocol(cpf = cpf)
            val response = protocolService.generateProtocol(newProtocol)
            ResponseEntity.ok(StatusResponse(response.protocol, "Protocolo criado com sucesso",200))
        }catch (ex:Exception){
            ResponseEntity
                    .badRequest()
                    .body(StatusResponse("0","Ocorreu um erro ao criar o protocolo!", -1))
        }
    }

    @GetMapping("/{cpf}")
    fun findByCPF(@PathVariable cpf:String):ResponseEntity<ProtocolHistoricResponse>{
        try{
            val response = protocolService.findByCPF(cpf)
            return ResponseEntity.ok(response)
        }catch (ex:Exception){
            return ResponseEntity.notFound().build()
        }

    }


}