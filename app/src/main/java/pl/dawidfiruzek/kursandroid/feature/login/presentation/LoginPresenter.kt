package pl.dawidfiruzek.kursandroid.feature.login.presentation

import android.Manifest
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions.PermissionsHelper
import timber.log.Timber

class LoginPresenter(
        private val view: LoginContract.View,
        private val router: LoginContract.Router,
        private val permissionsHelper: PermissionsHelper,
        private val compositeDisposable: CompositeDisposable
) : LoginContract.Presenter {

    companion object {
        const val NO_PERMISSIONS_MESSAGE = "You have to accept permissions to continue"
    }

    override fun initialize() {
        compositeDisposable.add(
                getCombinedObservable()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { Timber.d("All permissions granted and button clicked!") },
                                { Timber.e(it) }
                        )
        )
    }

    private fun getCombinedObservable(): Observable<Unit> =
            Observable.combineLatest(
                    getPermissionGrantedObservable(),
                    view.getLoginClickedObservable()
                            .subscribeOn(AndroidSchedulers.mainThread())
                            .observeOn(AndroidSchedulers.mainThread()),
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
