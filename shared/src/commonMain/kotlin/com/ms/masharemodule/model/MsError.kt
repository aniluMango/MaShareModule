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
)