package com.ms.masharemodule

import com.ms.masharemodule.model.*
import com.ms.masharemodule.model.Error
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class GiftCardsRepo(private val configuration: DomainConfiguration) : BaseRepo(configuration) {


    suspend fun getGiftCards():GiftCardResponse {
        return try {
            val url = configuration.baseURl + "v2/recognitions/tango_gift_cards.json"
            val get = client.get(url)
            get.body()
        } catch (e: Exception) {
            e.printStackTrace()
            GiftCardResponse(
                ms_errors = MsErrors(Error("Internal server error"), false)
            )
        }
    }



    suspend fun redeemGiftCard(redeemAmt: String,
                               utid: String,
                               giftCardLogo:String,
                               giftCardName:String
    ): PostRedemptionResponse {
        return try {
            val url = configuration.baseURl + "v2/recognitions/tango_card_order.json"
            val redeemGiftReq = RedeemReqModel(MsRequest(amount = redeemAmt,utid = utid, gift_card_logo = giftCardLogo, gift_card_name = giftCardName))
            val get = client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(redeemGiftReq)
            }
            get.body() as PostRedemptionResponse

        } catch (e: Exception) {
            e.printStackTrace()
            PostRedemptionResponse(ms_errors = MsErrors(Error("Internal server error"), false))
        }
    }

    suspend fun getGiftCardHistory(limit:Int,page:Int):GiftCardHistoryResponse {
        return try {
            val url = configuration.baseURl + "v2/recognitions/redemption_history.json?&limit=${limit}&offset=${page}"
            val get = client.get(url)
            get.body()
        } catch (e: Exception) {
            e.printStackTrace()
            GiftCardHistoryResponse(
                ms_errors = MsErrors(Error("Internal server error"), false)
            )
        }
    }

    suspend fun resendGiftCardMsg(id: String): PostRedemptionResponse {
        return try {
            val url = configuration.baseURl + "/v2/recognitions/${id}/resend_redeemption_message.json"
            val get = client.put(url) {
                contentType(ContentType.Application.Json)
                setBody("{\"ms_request\": {\"id\": \"$id\"}}")
            }
            get.body() as PostRedemptionResponse

        } catch (e: Exception) {
            e.printStackTrace()
            PostRedemptionResponse(ms_errors = MsErrors(Error("Internal server error"), false))
        }
    }
}


