package pl.dawidfiruzek.kursandroid.feature.splash.presentation

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verifyNoMoreInteractions
import org.mockito.MockitoAnnotations
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract

class SplashPresenterTest {

    @Mock
    private lateinit var view: SplashContract.View

    @Mock
    private lateinit var router: SplashContract.Router

    private lateinit var presenter: SplashContract.Presenter

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = SplashPresenter(
                view,
                router
        )
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(view, router)
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