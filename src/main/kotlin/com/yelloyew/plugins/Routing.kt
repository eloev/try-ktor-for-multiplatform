package com.yelloyew.plugins

import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import java.io.File

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("ready")
        }
        get("/image/{path}") {
            try {
                val path = call.parameters["path"]!!
                val file = File("resources/$path")

                call.respondFile(file)
            } catch (e: Exception) {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        get("/audio/{path}") {
            try {
                val path = call.parameters["path"]!!
                val file = File("audio/$path")

                call.respondFile(file)
            } catch (e: Exception) {
                val file = File("audio/findout.mp3")
                call.respondFile(file)
                call.respond(HttpStatusCode.BadRequest)
            }
        }
    }
}
