package pl.dawidfiruzek.kursandroid.feature.splash.presentation

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.Configuration

class SplashPresenterTest {

    @Mock
    private lateinit var view: SplashContract.View

    @Mock
    private lateinit var router: SplashContract.Router

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var presenter: SplashContract.Presenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = SplashPresenter(
                view,
                router,
                configuration
        )
    }

    @After
    fun tearDown() {
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
    fun `should navigate to login when user is not logged in`() {
        `when`(configuration.isUserLoggedIn()).thenReturn(false)

        presenter.visible()

        verify(configuration, times(1)).isUserLoggedIn()
        verify(router, times(1)).navigateToLogin()
    }

    @Test
    fun `should navigate to repositories when user is logged in`() {
        `when`(configuration.isUserLoggedIn()).thenReturn(true)

        presenter.visible()

        verify(configuration, times(1)).isUserLoggedIn()
        verify(router, times(1)).navigateToRepositories()
    }
}