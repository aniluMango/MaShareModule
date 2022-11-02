package com.ms.masharemodule

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


open class BaseRepo(configuration: DomainConfiguration) {
    val client = HttpClient {

        defaultRequest {
            header(HttpHeaders.Cookie, configuration.cookie)
        }
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                }
            )
        }
        install(Logging) {
            logger = Logger.SIMPLE
            level = LogLevel.ALL
        }
    }

}


data class DomainConfiguration(val baseURl: String, val cookie: String)