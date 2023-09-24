package com.yelloyew

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.yelloyew.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "192.168.1.11", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}
