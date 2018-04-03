package pl.dawidfiruzek.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.login.navigation.LoginRouter
import pl.dawidfiruzek.kursandroid.feature.login.presentation.LoginPresenter
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions.PermissionsHelper
import pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions.PermissionsHelperImpl

@Module
class LoginModule {

    @Provides
    fun permissionsHelper(activity: LoginActivity): PermissionsHelper =
            PermissionsHelperImpl(activity)

    @Provides
    fun router(
            activity: LoginActivity
    ): LoginContract.Router =
            LoginRouter(activity)

    @Provides
    fun presenter(
            activity: LoginActivity,
            router: LoginContract.Router,
            permissionsHelper: PermissionsHelper,
            compositeDisposable: CompositeDisposable
    ): LoginContract.Presenter =
            LoginPresenter(
                    activity,
                    router,
                    permissionsHelper,
                    compositeDisposable
            )
}
