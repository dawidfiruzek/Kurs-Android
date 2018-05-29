package pl.dawidfiruzek.kursandroid.feature.splash

import pl.dawidfiruzek.kursandroid.feature.commons.BaseContract

interface SplashContract {

    interface Router {
        fun navigateToLogin()
        fun navigateToRepositories()
    }

    interface Presenter : BaseContract.Presenter {
        fun visible()
        fun hide()
    }
}
