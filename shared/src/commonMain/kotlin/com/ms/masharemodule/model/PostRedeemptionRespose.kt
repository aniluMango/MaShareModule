package com.ms.masharemodule.model

import kotlinx.serialization.SerialName

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
    @SerialName("ms_response")
    val ms_response: PostRedemptionResponseMS?=null,
    val ms_errors: MsErrors?=null
)


@kotlinx.serialization.Serializable
data class PostRedemptionResponseMS(
    val message: String? = null,
    val available_reward_points: String? = null,
    val success: Boolean? = false,
)
