package pl.dawidfiruzek.kursandroid.feature.login

import io.reactivex.Observable
import pl.dawidfiruzek.kursandroid.feature.commons.BaseContract

interface LoginContract {

    interface View {
        fun showMessage(message: String)
        fun getLoginClickedObservable(): Observable<Unit>
    }

    interface Router {
        fun finish()
    }

    interface Presenter : BaseContract.Presenter
}
