package pl.dawidfiruzek.kursandroid.feature.splash.navigation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity

class SplashRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: SplashActivity

    private lateinit var router: SplashContract.Router

    override fun setup() {
        super.setup()
        router = SplashRouter(activity)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(activity)
    }

    @Test
    fun `should navigate to login activity when navigateToLogin is called`() {
        router.navigateToLogin()

        verify(activity, times(1)).startActivity(LoginActivity::class.java)
    }

    @Test
    fun `should navigate to repositories activity when navigateToRepositories is called`() {
        router.navigateToRepositories()

        verify(activity, times(1)).startActivity(RepositoriesActivity::class.java)
    }
}