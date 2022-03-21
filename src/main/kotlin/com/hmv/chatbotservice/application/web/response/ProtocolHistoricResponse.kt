package com.hmv.chatbotservice.application.web.response

import com.hmv.chatbotservice.domain.entity.Protocol
import com.hmv.chatbotservice.domain.entity.ProtocolHistoric

class ProtocolHistoricResponse (
        val cpf:String,
        val protocolHistoric: List<ProtocolHistoric>
        )