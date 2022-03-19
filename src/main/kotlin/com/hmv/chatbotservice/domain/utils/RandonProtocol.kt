package com.hmv.chatbotservice.domain.utils
import org.apache.commons.lang3.StringUtils
import java.time.LocalDateTime
import java.util.Random

class RandonProtocol {

    val random = Random()

    private fun rand() : Int {
        return random.nextInt(9999 - 1) + 9999
    }

    fun protocol():String{
        var newProtocol = rand().toString() + LocalDateTime.now().toString()
        newProtocol = StringUtils.replace(newProtocol,".","")
        newProtocol = StringUtils.replace(newProtocol,"-","")
        newProtocol = StringUtils.replace(newProtocol,":","")
        return newProtocol

    }

}