import com.ms.masharemodule.DomainConfiguration
import com.ms.masharemodule.GiftCardsRepo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class SampleTests {
    private val domain = "lms1.mangopulse.com"// "lms1.mangopulse.com"
    private val cookies = "_felix_session_id=6956405a81333ebebf7b204214463c26"
    private val repo = GiftCardsRepo(
        DomainConfiguration(
            "https://$domain/api/",
            cookies
        )
    )


    @Test
    fun standardTest() = runTest {
        launch { repo.getGiftCards().ms_response?.tango_cards?.brand_info?.isNotEmpty() }
    }



    @Test
    fun postRedemption() = runTest {
        launch {
           val response =  repo.redeemGiftCard("5","U903652","https://dwwvg90koz96l.cloudfront.net/images/brands/b157294-1200w-326ppi.png","American Cancer Society Donation")
            response.ms_errors?.apply {
                println(response.ms_errors!!.error.message)
                println(response.ms_errors!!.success)
            }

            response.ms_response?.apply{
                println(response.ms_response!!.message)
                println(response.ms_response!!.success)
            }
        }
    }

    @Test
    fun getGiftCardHistory() = runTest {
        launch { assertTrue { repo.getGiftCardHistory(10,1).ms_response!!.redemption_history.size == 10 }}
    }

    @Test
    fun resendGiftMsg() = runTest {
        launch {
           val response =  repo.resendGiftCardMsg("31")
            response.ms_errors?.apply {
                println(response.ms_errors!!.error.message)
                println(response.ms_errors!!.success)
            }

            response.ms_response?.apply{
                println(response.ms_response!!.message)
                println(response.ms_response!!.success)
            }
        }
    }
}