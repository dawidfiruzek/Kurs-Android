package pl.dawidfiruzek.kursandroid.feature.splash.presentation

import io.reactivex.disposables.CompositeDisposable
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.Configuration

class SplashPresenterTest : BaseTest() {

    @Mock
    private lateinit var router: SplashContract.Router

    @Mock
    private lateinit var configuration: Configuration

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var presenter: SplashContract.Presenter

    override fun setup() {
        super.setup()
        trampolineRxPlugin()
        presenter = SplashPresenter(
                router,
                configuration,
                compositeDisposable
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                router,
                configuration,
                compositeDisposable
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

        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(configuration, times(1)).isUserLoggedIn()
        verify(router, times(1)).navigateToLogin()
    }

    @Test
    fun `should navigate to repositories when user is logged in`() {
        val exampleExtra = 322
        `when`(configuration.isUserLoggedIn()).thenReturn(true)
        `when`(configuration.exampleExtra).thenReturn(exampleExtra)

        presenter.visible()

        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(configuration, times(1)).isUserLoggedIn()
        verify(configuration, times(1)).exampleExtra
        verify(router, times(1)).navigateToRepositories(exampleExtra)
    }

    @Test
    fun `should clear composite disposable when hide is called`() {
        presenter.hide()

        verify(compositeDisposable, times(1)).clear()
    }
}