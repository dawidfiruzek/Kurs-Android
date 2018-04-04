package pl.dawidfiruzek.kursandroid.feature.repositories

import pl.dawidfiruzek.kursandroid.feature.commons.BaseContract

interface RepositoriesContract {

    interface View
    interface Router {
        fun navigateToLogin()
    }

    interface Presenter : BaseContract.Presenter {
        fun logoutClicked()
    }
}
