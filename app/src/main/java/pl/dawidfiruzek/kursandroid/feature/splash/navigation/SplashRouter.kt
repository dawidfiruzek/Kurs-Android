package pl.dawidfiruzek.kursandroid.feature.splash.navigation

import android.content.Intent
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity

class SplashRouter(
        private val activity: SplashActivity
) : SplashContract.Router {

    override fun navigateToLogin() {
        activity.startActivity(Intent(activity, LoginActivity::class.java))
    }

    override fun navigateToRepositories() {
        activity.startActivity(Intent(activity, RepositoriesActivity::class.java))
    }
}