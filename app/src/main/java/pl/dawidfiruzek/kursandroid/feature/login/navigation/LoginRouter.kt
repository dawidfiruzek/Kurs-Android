package pl.dawidfiruzek.kursandroid.feature.login.navigation

import android.content.Intent
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.login.ui.LoginActivity
import pl.dawidfiruzek.kursandroid.feature.repositories.ui.RepositoriesActivity

class LoginRouter(
        private val activity: LoginActivity
) : LoginContract.Router {

    override fun finish() {
        activity.finish()
    }

    override fun navigateToRepositories() {
        activity.startActivity(
                RepositoriesActivity::class.java,
                listOf(
                        Intent.FLAG_ACTIVITY_NEW_TASK,
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
                )
        )
    }
}
