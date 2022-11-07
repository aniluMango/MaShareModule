package com.ms.masharemodule.model
@kotlinx.serialization.Serializable
data class GiftCardHistory(
val amount: Int,
val card_logo: String?=null,
val card_name: String?=null,
val created_at: String,
val id: Int,
val points_used: String?=null,
val reference_order_id: String,
val status: String,
val unit: String?=null,
val redeemed_by: String?=null,

)

