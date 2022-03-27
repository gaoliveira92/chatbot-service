package com.hmv.chatbotservice.utils

import com.hmv.chatbotservice.application.web.request.IntentRequest
import com.hmv.chatbotservice.application.web.request.ParametersRequest
import com.hmv.chatbotservice.application.web.request.ProtocolHistoryRequest
import com.hmv.chatbotservice.application.web.request.QueryResultRequest

class ProtocolHistoricRequestFakeData {
    fun get() = ProtocolHistoryRequest(
            "protocol1",
            QueryResultRequest(
                    "params",
                    "messages",
                    "text",
                    IntentRequest(
                            "Display name",
                            "name"
                    ),
                    "intent",
                    "language",
                    ParametersRequest(
                            "location",
                            "url"
                    ),
                    "text"

            ),
            "response-id"
    )
}