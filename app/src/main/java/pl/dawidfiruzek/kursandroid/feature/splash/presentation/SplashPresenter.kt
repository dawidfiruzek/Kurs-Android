package pl.dawidfiruzek.kursandroid.feature.splash.presentation

import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.Configuration

class SplashPresenter(
        private val router: SplashContract.Router,
        private val configuration: Configuration
) : SplashContract.Presenter {

    override fun initialize() = Unit

    override fun clear() = Unit

    override fun visible() {
        if (configuration.isUserLoggedIn()) {
            router.navigateToRepositories()
        } else {
            router.navigateToLogin()
        }
    }
}