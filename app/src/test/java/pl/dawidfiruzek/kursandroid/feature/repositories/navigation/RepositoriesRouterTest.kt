package pl.dawidfiruzek.kursandroid.feature.repositories.navigation

import android.content.Intent
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest

class RepositoriesRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: RepositoriesActivity

    private lateinit var router: RepositoriesContract.Router

    override fun setup() {
        super.setup()
        router = RepositoriesRouter(activity)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(activity)
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
}
