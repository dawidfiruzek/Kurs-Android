package pl.dawidfiruzek.kursandroid.feature.login

import io.reactivex.Observable
import pl.dawidfiruzek.kursandroid.feature.commons.BaseContract

interface LoginContract {

    interface View {
        fun showMessage(message: String)
        fun getLoginClickedObservable(): Observable<Unit>
        fun getUsername(): String
    }

    interface Router {
        fun finish()
        fun navigateToRepositories()
    }

    interface Presenter : BaseContract.Presenter
}
