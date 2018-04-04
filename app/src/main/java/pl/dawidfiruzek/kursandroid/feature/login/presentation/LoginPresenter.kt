package pl.dawidfiruzek.kursandroid.feature.login.presentation

import android.Manifest
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsEvents
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsHelper
import pl.dawidfiruzek.kursandroid.utils.api.UsersService
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration
import pl.dawidfiruzek.kursandroid.utils.tools.permissions.PermissionsHelper
import timber.log.Timber

class LoginPresenter(
        private val view: LoginContract.View,
        private val router: LoginContract.Router,
        private val permissionsHelper: PermissionsHelper,
        private val usersService: UsersService,
        private val configuration: Configuration,
        private val analyticsHelper: AnalyticsHelper,
        private val compositeDisposable: CompositeDisposable
) : LoginContract.Presenter {

    companion object {
        const val NO_PERMISSIONS_MESSAGE = "You have to accept permissions to continue"
    }

    override fun initialize() {
        analyticsHelper.logEvent(AnalyticsEvents.LOGIN_OPENED)
        compositeDisposable.add(
                getCombinedObservable()
                        .switchMap {
                            usersService.user(view.getUsername())
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                        }
                        .distinct()
                        .subscribe(
                                {
                                    analyticsHelper.logEvent(AnalyticsEvents.LOGIN_REQUEST_SUCCESS)
                                    val userLogin = it.login
                                    Timber.d("Request is successful with user login: $userLogin")
                                    configuration.userLogin = userLogin
                                    router.navigateToRepositories()
                                },
                                { Timber.e(it) }
                        )
        )
    }

    private fun getCombinedObservable(): Observable<Unit> =
            Observable.combineLatest(
                    getPermissionGrantedObservable(),
                    view.getLoginClickedObservable()
                            .doOnNext { analyticsHelper.logEvent(AnalyticsEvents.LOGIN_BUTTON_CLICKED) },
                    BiFunction { _, _ -> Unit }
            )

    private fun getPermissionGrantedObservable(): Observable<Unit> =
            permissionsHelper
                    .request(Manifest.permission.CAMERA)
                    .doOnNext {
                        if (!it) {
                            Timber.d("No permissions granted...")
                            view.showMessage(NO_PERMISSIONS_MESSAGE)
                            router.finish()
                        }
                    }
                    .filter { it }
                    .map { Unit }

    override fun clear() {
        compositeDisposable.clear()
    }
}
