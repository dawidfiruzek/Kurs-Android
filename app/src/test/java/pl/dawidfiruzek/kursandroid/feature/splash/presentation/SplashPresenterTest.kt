package pl.dawidfiruzek.kursandroid.feature.splash.presentation

import org.junit.Before
import org.junit.Test
import org.mockito.Mock
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

    @Test
    fun initialize() {
    }

    @Test
    fun clear() {
    }
}