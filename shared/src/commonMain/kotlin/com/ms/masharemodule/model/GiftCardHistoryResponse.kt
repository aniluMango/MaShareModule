package com.ms.masharemodule.model


@kotlinx.serialization.Serializable
data class GiftCardHistoryResponse(
    val ms_response: MsResponse?=null,
    val ms_errors: MsErrors?=null
)