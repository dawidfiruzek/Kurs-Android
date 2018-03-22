package pl.dawidfiruzek.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.navigation.SplashRouter
import pl.dawidfiruzek.kursandroid.feature.splash.presentation.SplashPresenter
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.Configuration

@Module
class SplashModule {

    @Provides
    fun router(activity: SplashActivity): SplashContract.Router =
            SplashRouter(activity)

    @Provides
    fun presenter(
            router: SplashContract.Router,
            configuration: Configuration,
            compositeDisposable: CompositeDisposable
    ): SplashContract.Presenter =
            SplashPresenter(
                    router,
                    configuration,
                    compositeDisposable
            )
}