package com.ms.masharemodule.model


@kotlinx.serialization.Serializable
data class Error(
    val message: String,
    val code: Int?=null
)
@kotlinx.serialization.Serializable
data class MsErrors(
    val error: Error,
    val success: Boolean?=null,
    val transaction_id: String?=null,
    val error_code: String?=null,
    val CO: String?=null,
)

//response {error_code=200, CO=INVALID_SESSION}