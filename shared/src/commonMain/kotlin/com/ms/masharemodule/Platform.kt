package com.ms.masharemodule

import io.ktor.client.*

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform


