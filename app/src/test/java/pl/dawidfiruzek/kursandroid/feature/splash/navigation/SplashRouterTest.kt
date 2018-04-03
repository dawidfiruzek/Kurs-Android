package pl.dawidfiruzek.kursandroid.feature.splash.navigation

import android.content.Intent
import android.os.Parcelable
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.StringConstants.EXTRA_KEY_EXAMPLE
import pl.dawidfiruzek.kursandroid.feature.utils.tools.parcel.ParcelableProvider

class SplashRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: SplashActivity

    @Mock
    private lateinit var parcelableProvider: ParcelableProvider

    @Mock
    private lateinit var parcelable: Parcelable

    private lateinit var router: SplashContract.Router

    override fun setup() {
        super.setup()
        router = SplashRouter(
                activity,
                parcelableProvider
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                activity,
                parcelableProvider
        )
    }

    @Test
    fun `should start login activity when navigateToLogin is called`() {
        router.navigateToLogin()

        verify(activity, times(1)).startActivity(
                LoginActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
    }

    @Test
    fun `should start repositories activity when navigateToRepositories is called`() {
        val extra = 12
        `when`(parcelableProvider.from(extra)).thenReturn(parcelable)

        router.navigateToRepositories(extra)

        verify(parcelableProvider, times(1)).from(extra)
        verify(activity, times(1)).startActivity(
                RepositoriesActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                ),
                Pair(EXTRA_KEY_EXAMPLE, parcelable)
        )
    }
}