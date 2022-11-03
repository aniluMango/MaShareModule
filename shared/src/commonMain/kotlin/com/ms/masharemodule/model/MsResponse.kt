package com.ms.masharemodule.model

@kotlinx.serialization.Serializable
data class MsResponse(
    val tango_cards: TangoCards?=null,
    val redemption_history: List<GiftCardHistory> = arrayListOf(),
    val message: String? = null,
    val success: Boolean? = false,
)