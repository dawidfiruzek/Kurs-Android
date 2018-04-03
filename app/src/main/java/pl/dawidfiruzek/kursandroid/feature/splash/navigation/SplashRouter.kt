package pl.dawidfiruzek.kursandroid.feature.splash.navigation

import android.content.Intent
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.StringConstants.EXTRA_KEY_EXAMPLE
import pl.dawidfiruzek.kursandroid.feature.utils.tools.parcel.ParcelableProvider

class SplashRouter(
        private val activity: SplashActivity,
        private val parcelableProvider: ParcelableProvider
) : SplashContract.Router {

    override fun navigateToLogin() {
        activity.startActivity(
                LoginActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
    }

    override fun navigateToRepositories(exampleExtra: Int) {
        activity.startActivity(
                RepositoriesActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                ),
                Pair(
                        EXTRA_KEY_EXAMPLE,
                        parcelableProvider.from(exampleExtra)
                )
        )
    }
}