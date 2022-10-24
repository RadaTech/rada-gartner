package no.rada

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import no.rada.vanning.VanningService
import no.rada.vanning.vanningController
import org.slf4j.LoggerFactory

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    val logger = LoggerFactory.getLogger(this::class.java).also { it.info("Starter opp applikasjonen") }
    settOppRouting()
}

private fun Application.settOppRouting(){
    routing {
        vanningController(VanningService())
        get {
            call.respond(status = HttpStatusCode.Accepted, message = "Hello world!")
        }
    }
}
