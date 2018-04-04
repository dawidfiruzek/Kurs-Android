package pl.dawidfiruzek.kursandroid.feature.repositories

import pl.dawidfiruzek.kursandroid.data.RepositoryData
import pl.dawidfiruzek.kursandroid.feature.commons.BaseContract

interface RepositoriesContract {

    interface View {
        fun updateRepos(data: List<RepositoryData>)
    }

    interface Router {
        fun navigateToLogin()
    }

    interface Presenter : BaseContract.Presenter {
        fun logoutClicked()
    }
}
