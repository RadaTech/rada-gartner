package no.rada.vanning

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.slf4j.LoggerFactory

fun Route.vanningController(
    vanningService: VanningService
){
    val logger = LoggerFactory.getLogger(this::class.java)

    route("/vanning") {
        post {
            try {
                val mengdeVann = call.parameters["mengde"]!!.toDouble()
                logger.info("Forespørsel om å vanne plante med $mengdeVann dl vann")
                vanningService.vannPlante(mengdeVann)
                call.respond(HttpStatusCode.Accepted)
            } catch (e: Exception) {
                logger.error("Vanning feilet. Exception = $e")
                call.respond(HttpStatusCode.BadRequest)
            }
        }
    }
}