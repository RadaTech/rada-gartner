package no.rada.vanning

import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*

class VanningTest {

    @Test
    fun `Vanning med 10 dl fungerer som forventet`(){
        testApplication {
            client.post(urlString = "/vanning?mengde=10").also {
                assertEquals(HttpStatusCode.Accepted, it.status)
            }
        }
    }

    @Test
    fun `Forventer feil dersom man ikke sender med 'mengde' paramter`(){
        testApplication {
            client.post(urlString = "/vanning").also {
                assertEquals(HttpStatusCode.BadRequest, it.status)
            }
        }
    }
}