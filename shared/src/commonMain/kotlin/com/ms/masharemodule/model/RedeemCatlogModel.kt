package com.ms.masharemodule.model

@kotlinx.serialization.Serializable
data class RedeemCatlogModel(
    val brand_key: String,
    val brand_name: String,
    val description: String,
    val image_urls: ImageUrls,
    val terms: String?,
    val uti_items: List<UtiItem> = arrayListOf(),
    val value_type: String
)
@kotlinx.serialization.Serializable

data class UtiItem(
    val amount: String,
    val redemption_instructions: String,
    val reward_name: String,
    val utid: String
)

@kotlinx.serialization.Serializable
data class ImageUrls(
    val i1200w_326ppi: String,
    val i130w_326ppi: String,
    val i200w_326ppi: String,
    val i278w_326ppi: String,
    val i300w_326ppi: String,
    val i80w_326ppi: String
)



@kotlinx.serialization.Serializable
data class GiftCardResponse(
    val ms_response: MsResponse?=null,
    val ms_errors: MsErrors?=null

)

@kotlinx.serialization.Serializable
data class TangoCards(
    val available_points: String,
    val unit:Int,
    val brand_info: List<RedeemCatlogModel>
)

