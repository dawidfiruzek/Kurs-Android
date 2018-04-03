package pl.dawidfiruzek.kursandroid.feature.login

import pl.dawidfiruzek.kursandroid.feature.commons.BaseContract

interface LoginContract {

    interface View {
        fun showMessage(message: String)
    }

    interface Router {
        fun finish()
    }

    interface Presenter : BaseContract.Presenter {
        fun visible()
        fun hidden()
    }
}
