package com.ms.masharemodule.model


@kotlinx.serialization.Serializable
data class Error(
    val message: String
)
@kotlinx.serialization.Serializable
data class MsErrors(
    val error: Error,
    val success: Boolean
)