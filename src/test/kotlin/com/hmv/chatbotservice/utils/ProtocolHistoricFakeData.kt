package com.hmv.chatbotservice.utils

import com.hmv.chatbotservice.domain.entity.ProtocolHistoric
import java.time.LocalDateTime

class ProtocolHistoricFakeData {

    fun get() = ProtocolHistoric(
            "id1",
            "protocol1",
            "data1",
            LocalDateTime.now()
    )

    fun getList() = listOf(
            ProtocolHistoric(
                "id1",
                "protocol1",
                "data1",
                LocalDateTime.now()
            ),
            ProtocolHistoric(
                    "id2",
                    "protocol1",
                    "data2",
                    LocalDateTime.now()
            ),
            ProtocolHistoric(
                    "id3",
                    "protocol2",
                    "data3",
                    LocalDateTime.now()
            )
    )
}