package pl.dawidfiruzek.kursandroid.feature.login.presentation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest

class LoginPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var router: LoginContract.Router

    private lateinit var presenter: LoginContract.Presenter

    override fun setup() {
        super.setup()
        presenter = LoginPresenter(
                view,
                router
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                view,
                router
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
