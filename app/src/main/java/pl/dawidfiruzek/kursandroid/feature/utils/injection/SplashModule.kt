package pl.dawidfiruzek.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.navigation.SplashRouter
import pl.dawidfiruzek.kursandroid.feature.splash.presentation.SplashPresenter
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.Configuration

@Module
class SplashModule {

    @Provides
    fun router(): SplashContract.Router =
            SplashRouter()

    @Provides
    fun presenter(
            router: SplashContract.Router,
            configuration: Configuration
    ): SplashContract.Presenter =
            SplashPresenter(
                    router,
                    configuration
            )
}