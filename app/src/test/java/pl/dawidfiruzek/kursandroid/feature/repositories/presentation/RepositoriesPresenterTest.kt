package pl.dawidfiruzek.kursandroid.feature.repositories.presentation

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoMoreInteractions
import pl.dawidfiruzek.kursandroid.data.RepositoryData
import pl.dawidfiruzek.kursandroid.data.api.RepositoriesResponse
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsEvents
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsHelper
import pl.dawidfiruzek.kursandroid.utils.analytics.UserPropertyKeys
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

    @Mock
    private lateinit var exception: Exception

    @Mock
    private lateinit var reposResponse: RepositoriesResponse

    @Mock
    private lateinit var analyticsHelper: AnalyticsHelper

    private lateinit var presenter: RepositoriesContract.Presenter

    override fun setup() {
        super.setup()
        trampolineRxPlugin()
        presenter = RepositoriesPresenter(
                view,
                router,
                configuration,
                reposService,
                analyticsHelper,
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
                analyticsHelper,
                compositeDisposable,
                exception,
                reposResponse
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
        verify(analyticsHelper, times(1)).logEvent(AnalyticsEvents.REPOSITORIES_OPENED)
        verify(analyticsHelper, times(1)).setUserProperties(listOf(UserPropertyKeys.USERNAME to userLogin))
    }

    @Test
    fun `should update repos list when repos call is success`() {
        val userLogin = "user"
        val reposListResponse = listOf(reposResponse)
        val name = "Name"
        val description = "Description"
        val url = "url"
        val expectedRepositoryData = RepositoryData(
                name,
                description,
                url
        )
        `when`(reposService.repos(userLogin)).thenReturn(Observable.just(reposListResponse))
        `when`(reposResponse.name).thenReturn(name)
        `when`(reposResponse.description).thenReturn(description)
        `when`(reposResponse.imageUrl).thenReturn(url)

        initialize(userLogin)

        verify(reposResponse, times(1)).name
        verify(reposResponse, times(1)).description
        verify(reposResponse, times(1)).imageUrl
        verify(view, times(1)).updateRepos(listOf(expectedRepositoryData))
    }

    @Test
    fun `should do nothing when repos call is error`() {
        val userLogin = "user"
        `when`(reposService.repos(userLogin)).thenReturn(Observable.error(exception))

        initialize(userLogin)
    }

    @Test
    fun `should clear disposable when clear is called`() {
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }

    @Test
    fun `should logout and navigate to login when logoutClicked is called`() {
        presenter.logoutClicked()

        verify(analyticsHelper, times(1)).logEvent(AnalyticsEvents.LOGOUT_CLICKED)
        verify(configuration, times(1)).clear()
        verify(router, times(1)).navigateToLogin()
    }
}