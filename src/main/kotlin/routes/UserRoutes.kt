package routes

import com.example.data.Response
import kotlinx.serialization.decodeFromString
import com.example.data.User
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json

fun Application.configureRouting() {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }

    routing {

        post("/customer") {
            val requestBody = call.receive<User>()

            try {
                val response: HttpResponse =
                    client.post(<URL>) {
                        contentType(ContentType.Application.Json)
                        setBody(requestBody)
                    }

                // mapping json to Object
                val result = Json{ignoreUnknownKeys = true}.decodeFromString<Response>(response.bodyAsText())
                call.respond(result)

            } catch (e: Exception) {
                println(e)
            }
        }
    }
}