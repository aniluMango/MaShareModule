package com.ms.masharemodule

import com.ms.masharemodule.model.MsErrors
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


open class BaseRepo(val configuration: DomainConfiguration) {

    companion object {
        const val  RESPONSE_INVALID_SESSION = "INVALID_SESSION"
        const val  RESPONSE_DEVICE_DISABLED = "DEVICE_DISABLED"
        const val  RESPONSE_WIPEOUT_DEVICE = "WIPEOUT_DEVICE"
    }
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

    fun checkError(msErrors: MsErrors) {
        configuration.errorHanding?.apply {
            if (msErrors.CO == RESPONSE_INVALID_SESSION) {
                configuration.errorHanding.handleInvalidSession()
            } else if (msErrors.CO == RESPONSE_DEVICE_DISABLED) {
                configuration.errorHanding.handleDeviceDisable()
            } else if (msErrors.CO == RESPONSE_WIPEOUT_DEVICE) {
                configuration.errorHanding.handleWipeOut()
            }
        }
    }

}


data class DomainConfiguration(
    val baseURl: String,
    val cookie: String,
    val errorHanding: ErrorHanding? = null
)

interface ErrorHanding {
    fun handleWipeOut()
    fun handleDeviceDisable()
    fun handleInvalidSession()
}