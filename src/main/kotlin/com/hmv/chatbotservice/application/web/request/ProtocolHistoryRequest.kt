package com.hmv.chatbotservice.application.web.request

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
import java.time.LocalDateTime

data class ProtocolHistoryRequest (
        val queryResult:QueryResultRequest,
        val responseId: String
        )
data class QueryResultRequest(
        val allRequiredParamsPresent:String,
        val fullfilmentMessages: String,
        val fullfilmentText:String,
        val intent : IntentRequest,
        val intentDetectionConfidence: String,
        val languageCode: String,
        val parameters : ParametersRequest,
        val queryText: String,

        )

data class IntentRequest(
        val displayName:String,
        val name: String
)

data class ParametersRequest(
        val location: String,
        val url: String
)


fun ProtocolHistoryRequest.toProtocolHistory() = ProtocolHistoric(
        id = responseId,
        protocol = "",
        data = "Chatbot: ${queryResult.fullfilmentText} no Display: ${queryResult.intent.displayName}, " +
                "Usuario: ${queryResult.queryText} ",
        dateTime = LocalDateTime.now()
)