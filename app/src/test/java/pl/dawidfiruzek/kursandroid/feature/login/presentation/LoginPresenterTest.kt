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
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.login.presentation.LoginPresenter.Companion.NO_PERMISSIONS_MESSAGE
import pl.dawidfiruzek.kursandroid.feature.splash.BaseTest
import pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions.PermissionsHelper

class LoginPresenterTest : BaseTest() {

    @Mock
    private lateinit var view: LoginContract.View

    @Mock
    private lateinit var router: LoginContract.Router

    @Mock
    private lateinit var permissionsHelper: PermissionsHelper

    @Mock
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var presenter: LoginContract.Presenter

    override fun setup() {
        super.setup()
        presenter = LoginPresenter(
                view,
                router,
                permissionsHelper,
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
                compositeDisposable
        )
    }

    @Test
    fun `should subscribe for permissions changes when initialize is called`() {
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(PublishSubject.create())
        initialize()
    }

    private fun initialize() {
        presenter.initialize()

        verify(permissionsHelper, times(1)).request(Manifest.permission.CAMERA)
        verify(compositeDisposable, times(1)).add(ArgumentMatchers.any())
    }

    @Test
    fun `should clear composite disposable when clear is called`() {
        presenter.clear()

        verify(compositeDisposable, times(1)).clear()
    }

    @Test
    fun `should show message and finish when permissions are not granted`() {
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(Observable.just(false))

        initialize()

        verify(view, times(1)).showMessage(NO_PERMISSIONS_MESSAGE)
        verify(router, times(1)).finish()
    }

    @Test
    fun `should do nothing when permissions are granted`() {
        `when`(permissionsHelper.request(Manifest.permission.CAMERA)).thenReturn(Observable.just(true))
        initialize()
    }
}
