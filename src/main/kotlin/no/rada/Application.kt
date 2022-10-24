package no.rada

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    settOppRouting()
}

private fun Application.settOppRouting(){
    routing {
        get {
            call.respond(status = HttpStatusCode.Accepted, message = "Hello world!")

        }
    }
}
