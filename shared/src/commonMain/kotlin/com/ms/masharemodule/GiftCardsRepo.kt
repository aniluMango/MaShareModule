package com.ms.masharemodule

import com.ms.masharemodule.model.GiftCardDataResponse
import com.ms.masharemodule.model.GiftCardResponse
import com.ms.masharemodule.model.MsResponse
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class GiftCardsRepo(private val configuration: DomainConfiguration) :BaseRepo(configuration){
    suspend fun getGiftCards(): GiftCardDataResponse {
        return try {
           val url = configuration.baseURl + "v2/recognitions/tango_gift_cards.json"
            println("------------------------------------ $url ")
            val get = client.get(url)
            println("------------------------------------ ${get.bodyAsText()} ")
            println("------------------------------------ ${get.status} ")
            val response:GiftCardResponse = get.body()
            if (get.status == HttpStatusCode.OK) {
                GiftCardDataResponse(
                    response.ms_response.tango_cards.brand_info,
                    false,
                    get.status.value,
                    ""
                )
            }else{
                GiftCardDataResponse(
                    null,
                    false,
                    get.status.value,
                    "Server Error"
                )
            }

        }catch (e:Exception){
            e.printStackTrace()
            GiftCardDataResponse(
                null,
                false,
                400,
                e.message?:"Server Error"
            )
        }
    }
}


