package pl.dawidfiruzek.kursandroid.feature.repositories.presentation

import pl.dawidfiruzek.kursandroid.feature.repositories.RepositoriesContract
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration

class RepositoriesPresenter(
        private val view: RepositoriesContract.View,
        private val router: RepositoriesContract.Router,
        private val configuration: Configuration
) : RepositoriesContract.Presenter {

    override fun initialize() = Unit

    override fun clear() = Unit

    override fun logoutClicked() {
        configuration.clear()
        router.navigateToLogin()
    }
}
