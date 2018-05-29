package pl.dawidfiruzek.kursandroid.feature.login.presentation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions.PermissionsHelper

class LoginPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var router: LoginContract.Router

    @Mock
    private lateinit var permissionsHelper: PermissionsHelper

    private lateinit var presenter: LoginContract.Presenter

    override fun setup() {
        super.setup()
        presenter = LoginPresenter(
                view,
                router,
                permissionsHelper
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                view,
                router,
                permissionsHelper
        )
    }

    @Test
    fun `should do nothing when initialize is called`() {
        presenter.initialize()
    }

    @Test
    fun `should do nothing when clear is called`() {
        presenter.clear()
    }
}
