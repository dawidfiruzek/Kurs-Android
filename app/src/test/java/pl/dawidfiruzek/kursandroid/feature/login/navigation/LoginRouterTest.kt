package pl.dawidfiruzek.kursandroid.feature.login.navigation

import org.mockito.Mock
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
}
