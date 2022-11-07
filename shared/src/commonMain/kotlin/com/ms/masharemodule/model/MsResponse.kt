package com.ms.masharemodule.model


@kotlinx.serialization.Serializable
data class MsResponse(
    val message: String? = null,
    val available_reward_points: String? = null,
    val success: Boolean? = false,
)

