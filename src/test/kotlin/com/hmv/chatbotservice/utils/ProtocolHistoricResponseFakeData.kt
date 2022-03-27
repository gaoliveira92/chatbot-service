package com.hmv.chatbotservice.utils

import com.hmv.chatbotservice.application.web.response.ProtocolHistoricResponse

class ProtocolHistoricResponseFakeData {
    fun get() = ProtocolHistoricResponse(
            ProtocolFakeData().get().cpf,
            ProtocolHistoricFakeData().getList()
    )
}