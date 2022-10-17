package com.ms.masharemodule

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform