package pl.dawidfiruzek.kursandroid.feature.login.presentation

import pl.dawidfiruzek.kursandroid.feature.login.LoginContract

class LoginPresenter(
        private val view: LoginContract.View,
        private val router: LoginContract.Router
) : LoginContract.Presenter {

    override fun initialize() = Unit

    override fun clear() = Unit
}
