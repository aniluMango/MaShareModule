package com.ms.masharemodule.model
@kotlinx.serialization.Serializable
data class MsRequest(
    val amount: String,
    val gift_card_logo: String,
    val gift_card_name: String,
    val utid: String
)
@kotlinx.serialization.Serializable
data class RedeemReqModel(
    val ms_request: MsRequest
)


@kotlinx.serialization.Serializable
data class PostRedemptionResponse(
    val ms_response: MsResponse?=null,
    val ms_errors: MsErrors?=null
)

