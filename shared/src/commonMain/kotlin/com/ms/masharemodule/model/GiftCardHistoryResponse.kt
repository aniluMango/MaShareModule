package com.ms.masharemodule.model

import kotlinx.serialization.SerialName


@kotlinx.serialization.Serializable
data class GiftCardHistoryResponse(
    @SerialName("ms_response")
    val ms_response: RedemptionHistoryResponse?=null,
    val ms_errors: MsErrors?=null
)


@kotlinx.serialization.Serializable
data class RedemptionHistoryResponse(
    val redemption_history: List<GiftCardHistory> = arrayListOf(),
)
