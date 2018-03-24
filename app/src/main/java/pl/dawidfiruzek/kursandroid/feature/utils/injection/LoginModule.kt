package pl.dawidfiruzek.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.login.navigation.LoginRouter
import pl.dawidfiruzek.kursandroid.feature.login.presentation.LoginPresenter
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity

@Module
class LoginModule {

    @Provides
    fun router(
            activity: LoginActivity
    ): LoginContract.Router =
            LoginRouter(activity)

    @Provides
    fun presenter(
            activity: LoginActivity,
            router: LoginContract.Router
    ): LoginContract.Presenter =
            LoginPresenter(
                    activity,
                    router
            )
}
