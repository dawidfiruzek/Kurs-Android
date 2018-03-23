package pl.dawidfiruzek.kursandroid.feature.splash.navigation

import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity

class SplashRouter(
        private val activity: SplashActivity
) : SplashContract.Router {

    override fun navigateToLogin() {
        activity.startActivity(LoginActivity::class.java)
    }

    override fun navigateToRepositories() {
        activity.startActivity(RepositoriesActivity::class.java)
    }
}