package pl.dawidfiruzek.kursandroid.feature.splash.presentation

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsEvents
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsHelper
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration
import timber.log.Timber
import java.util.concurrent.TimeUnit

class SplashPresenter(
        private val router: SplashContract.Router,
        private val configuration: Configuration,
        private val analyticsHelper: AnalyticsHelper,
        private val compositeDisposable: CompositeDisposable
) : SplashContract.Presenter {

    companion object {
        const val TIMEOUT = 1500L
    }

    override fun initialize() {
        analyticsHelper.logEvent(AnalyticsEvents.SPLASH_OPENED)
    }

    override fun clear() = Unit

    override fun visible() {
        compositeDisposable.add(
                Observable.just(Unit)
                        .delay(TIMEOUT, TimeUnit.MILLISECONDS)
                        .subscribe(
                                { navigation() },
                                { Timber.e(it) }
                        )
        )
    }

    private fun navigation() {
        if (configuration.isUserLoggedIn()) {
            router.navigateToRepositories(configuration.exampleExtra)
        } else {
            router.navigateToLogin()
        }
    }

    override fun hidden() {
        compositeDisposable.clear()
    }
}