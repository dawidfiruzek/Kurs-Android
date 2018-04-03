package pl.dawidfiruzek.kursandroid.utils.injection

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.navigation.SplashRouter
import pl.dawidfiruzek.kursandroid.feature.splash.presentation.SplashPresenter
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration
import pl.dawidfiruzek.kursandroid.utils.tools.parcel.ParcelableProvider
import pl.dawidfiruzek.kursandroid.utils.tools.parcel.ParcelableProviderImpl

@Module
class SplashModule {

    @Provides
    fun parcelableProvider(): ParcelableProvider =
            ParcelableProviderImpl()

    @Provides
    fun router(
            activity: SplashActivity,
            parcelableProvider: ParcelableProvider
    ): SplashContract.Router =
            SplashRouter(
                    activity,
                    parcelableProvider
            )

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