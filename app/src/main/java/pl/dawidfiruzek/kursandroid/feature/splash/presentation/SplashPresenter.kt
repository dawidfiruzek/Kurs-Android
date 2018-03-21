package pl.dawidfiruzek.kursandroid.feature.splash.presentation

import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import timber.log.Timber

class SplashPresenter(
        private val view: SplashContract.View,
        private val router: SplashContract.Router
) : SplashContract.Presenter {

    override fun initialize() {
        Timber.d("Presenter is initialized!")
    }

    override fun clear() {
        Timber.d("Presenter is cleared!")
    }
}