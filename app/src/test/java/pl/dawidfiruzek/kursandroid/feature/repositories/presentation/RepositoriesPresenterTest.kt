package pl.dawidfiruzek.kursandroid.feature.repositories.presentation

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.utils.api.ReposService
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration

class RepositoriesPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: RepositoriesContract.View

    @Mock
    private lateinit var router: RepositoriesContract.Router

    @Mock
    private lateinit var configuration: Configuration

    @Mock
    private lateinit var reposService: ReposService

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var presenter: RepositoriesContract.Presenter

    override fun setup() {
        super.setup()
        presenter = RepositoriesPresenter(
                view,
                router,
                configuration,
                reposService,
                compositeDisposable
        )
    }

    override fun tearDown() {
        super.tearDown()
        verifyNoMoreInteractions(
                view,
                router,
                configuration,
                reposService,
                compositeDisposable
        )
    }

    @Test
    fun `should subscribe for repos response when initialize is called`() {
        val userLogin = "user"
        `when`(reposService.repos(userLogin)).thenReturn(PublishSubject.create())

        initialize(userLogin)
    }

    private fun initialize(userLogin: String) {
        `when`(configuration.userLogin).thenReturn(userLogin)

        presenter.initialize()

        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(configuration, times(1)).userLogin
        verify(reposService, times(1)).repos(userLogin)
    }

    @Test
    fun `should clear disposable when clear is called`() {
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }

    @Test
    fun `should logout and navigate to login when logoutClicked is called`() {
        presenter.logoutClicked()

        verify(configuration, times(1)).clear()
        verify(router, times(1)).navigateToLogin()
    }
}