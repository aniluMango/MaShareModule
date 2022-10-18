package com.ms.masharemodule.model

import kotlinx.serialization.Serializable

@Serializable
data class RedeemCatlogModel(
    val brand_key: String,
    val brand_name: String,
    val denominations: String,
    val description: String,
    val image_urls: ImageUrls,
    val terms: String?,
    val utid: String?
)
@Serializable
data class ImageUrls(
    val i1200w_326ppi: String,
    val i130w_326ppi: String,
    val i200w_326ppi: String,
    val i278w_326ppi: String,
    val i300w_326ppi: String,
    val i80w_326ppi: String
)

@Serializable
data class MsResponse(
    val tango_cards: TangoCards
)
@Serializable
data class GiftCardResponse(
    val ms_response: MsResponse
)
@Serializable
data class TangoCards(
    val available_points: String,
    val brand_info: List<RedeemCatlogModel>
)
@Serializable
data class GiftCardDataResponse(val data:List<RedeemCatlogModel>?, val isError:Boolean,
                                val code :Int, val message:String)