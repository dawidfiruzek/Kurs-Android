package pl.dawidfiruzek.kursandroid.feature.login.presentation

import android.Manifest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
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

    override fun initialize() = Unit

    override fun clear() = Unit

    override fun visible() {
        compositeDisposable.add(
                permissionsHelper
                        .request(Manifest.permission.CAMERA)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    if (it) {
                                        Timber.d("All permissions granted!")
                                    }
                                    else {
                                        view.showMessage(NO_PERMISSIONS_MESSAGE)
                                        router.finish()
                                    }
                                },
                                { Timber.e(it) }
                        )
        )
    }

    override fun hidden() {
        compositeDisposable.clear()
    }
}
