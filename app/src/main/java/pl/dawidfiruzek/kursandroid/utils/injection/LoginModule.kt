package pl.dawidfiruzek.kursandroid.utils.injection

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.login.navigation.LoginRouter
import pl.dawidfiruzek.kursandroid.feature.login.presentation.LoginPresenter
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.utils.api.UsersService
import pl.dawidfiruzek.kursandroid.utils.tools.permissions.PermissionsHelper
import pl.dawidfiruzek.kursandroid.utils.tools.permissions.PermissionsHelperImpl
import retrofit2.Retrofit

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
    fun usersService(retrofit: Retrofit): UsersService =
            retrofit.create(UsersService::class.java)

    @Provides
    fun presenter(
            activity: LoginActivity,
            router: LoginContract.Router,
            permissionsHelper: PermissionsHelper,
            usersService: UsersService,
            compositeDisposable: CompositeDisposable
    ): LoginContract.Presenter =
            LoginPresenter(
                    activity,
                    router,
                    permissionsHelper,
                    usersService,
                    compositeDisposable
            )
}
