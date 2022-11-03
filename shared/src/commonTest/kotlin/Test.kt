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
    private val cookies = "_felix_session_id=24772b62cc0004216ea4f76157cec9fa"
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
           val response =  repo.redeemGiftCard("1","U903652","https://dwwvg90koz96l.cloudfront.net/images/brands/b157294-1200w-326ppi.png","American Cancer Society Donation")
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
        launch { assertTrue { repo.getGiftCardHistory().ms_response!!.redemption_history.isNotEmpty() }}
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