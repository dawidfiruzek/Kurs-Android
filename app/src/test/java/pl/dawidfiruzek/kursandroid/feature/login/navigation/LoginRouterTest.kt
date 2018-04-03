package pl.dawidfiruzek.kursandroid.feature.login.navigation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest

class LoginRouterTest : BaseTest() {

    @Mock
    private lateinit var activity: LoginActivity

    private lateinit var router: LoginContract.Router

    override fun setup() {
        super.setup()
        router = LoginRouter(activity)
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(activity)
    }

    @Test
    fun `should finish activity when finish is called`() {
        router.finish()

        verify(activity, times(1)).finish()
    }
}
