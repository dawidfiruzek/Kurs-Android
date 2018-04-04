package pl.dawidfiruzek.kursandroid.feature.login.presentation

import android.Manifest
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
import pl.dawidfiruzek.kursandroid.data.api.UsersResponse
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.login.presentation.LoginPresenter.Companion.NO_PERMISSIONS_MESSAGE
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.utils.api.UsersService
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration
import pl.dawidfiruzek.kursandroid.utils.tools.permissions.PermissionsHelper

class LoginPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var router: LoginContract.Router

    @Mock
    private lateinit var permissionsHelper: PermissionsHelper

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    @Mock
    private lateinit var usersService: UsersService

    @Mock
    private lateinit var usersResponse: UsersResponse

    @Mock
    private lateinit var configuration: Configuration

    private lateinit var presenter: LoginContract.Presenter

    override fun setup() {
        super.setup()
        presenter = LoginPresenter(
                view,
                router,
                permissionsHelper,
                usersService,
                configuration,
                compositeDisposable
        )
    }

    override fun tearDown() {
        super.tearDown()
        trampolineRxPlugin()
        verifyNoMoreInteractions(
                view,
                router,
                permissionsHelper,
                usersService,
                compositeDisposable,
                usersResponse
        )
    }

    @Test
    fun `should subscribe for permissions changes when initialize is called`() {
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(PublishSubject.create())
        `when`(view.getLoginClickedObservable()).thenReturn(PublishSubject.create())

        initialize()
    }

    private fun initialize() {
        presenter.initialize()

        verify(permissionsHelper, times(1)).request(Manifest.permission.CAMERA)
        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
        verify(view, times(1)).getLoginClickedObservable()
    }

    @Test
    fun `should clear composite disposable when clear is called`() {
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }

    @Test
    fun `should show message and finish when permissions are not granted`() {
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(Observable.just(false))
        `when`(view.getLoginClickedObservable()).thenReturn(PublishSubject.create())

        initialize()

        verify(view, times(1)).showMessage(NO_PERMISSIONS_MESSAGE)
        verify(router, times(1)).finish()
    }

    @Test
    fun `should do api call when permissions are granted and button is clicked`() {
        val username = "username"
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(Observable.just(true))
        `when`(view.getLoginClickedObservable()).thenReturn(Observable.just(Unit))
        `when`(view.getUsername()).thenReturn(username)
        `when`(usersService.user(username)).thenReturn(Observable.just(usersResponse))
        `when`(usersResponse.login).thenReturn(username)

        initialize()

        verify(view, times(1)).getUsername()
        verify(usersService, times(1)).user(username)
        verify(usersResponse, times(1)).login
        verify(configuration, times(1)).userLogin = username
        verify(router, times(1)).navigateToRepositories()
    }
}
