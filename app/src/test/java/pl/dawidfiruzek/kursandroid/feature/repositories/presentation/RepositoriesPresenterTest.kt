package pl.dawidfiruzek.kursandroid.feature.repositories.presentation

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration

class RepositoriesPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: RepositoriesContract.View

    @Mock
    private lateinit var router: RepositoriesContract.Router

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var presenter: RepositoriesContract.Presenter

    override fun setup() {
        super.setup()
        presenter = RepositoriesPresenter(
                view,
                router,
                configuration
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                view,
                router,
                configuration
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

    @Test
    fun `should logout and navigate to login when logoutClicked is called`() {
        presenter.logoutClicked()

        verify(configuration, times(1)).clear()
        verify(router, times(1)).navigateToLogin()
    }
}