package no.rada.vanning

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import no.rada.vanning.VanningService.Companion.MINIMUM_MENGDE_VANN
import kotlin.test.*

class VanningControllerTest {

    @Test
    fun `Vanning med 10 dl fungerer som forventet`(){
        testApplication {
            client.post(urlString = "/vanning?mengde=10").also {
                assertEquals(HttpStatusCode.Accepted, it.status)
            }
        }
    }

    @Test
    fun `Forventer feil dersom man ikke sender med 'mengde' parameter`(){
        testApplication {
            client.post(urlString = "/vanning").also {
                assertEquals(HttpStatusCode.BadRequest, it.status)
            }
        }
    }

    @Test
    fun `Forventer feil dersom man prøver å vanne med for lite vann`(){
        testApplication {
            client.post(urlString = "/vanning?mengde=${MINIMUM_MENGDE_VANN-0.1}").also {
                assertEquals(HttpStatusCode.BadRequest, it.status)
            }
        }
    }
}