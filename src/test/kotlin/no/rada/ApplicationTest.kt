package no.rada

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {

    @Test
    fun `Test 1`(){
        assertTrue(true)
    }

    @Test
    fun `Test 2`(){
        testApplication {
            client.get("/").also {
                assertEquals(HttpStatusCode.Accepted, it.status)
                assertEquals("Hello world!", it.bodyAsText())
            }
        }
    }
}