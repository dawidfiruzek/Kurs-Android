package pl.dawidfiruzek.kursandroid.feature.repositories.navigation

import android.content.Intent
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity

class RepositoriesRouter(
        private val activity: RepositoriesActivity
) : RepositoriesContract.Router {

    override fun navigateToLogin() {
        activity.startActivity(
                LoginActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
    }
}
