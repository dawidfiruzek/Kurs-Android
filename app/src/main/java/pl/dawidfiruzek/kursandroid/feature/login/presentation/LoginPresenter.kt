package pl.dawidfiruzek.kursandroid.feature.login.presentation

import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import pl.dawidfiruzek.kursandroid.feature.utils.tools.permissions.PermissionsHelper

class LoginPresenter(
        private val view: LoginContract.View,
        private val router: LoginContract.Router,
        private val permissionsHelper: PermissionsHelper
) : LoginContract.Presenter {

    override fun initialize() = Unit

    override fun clear() = Unit
}
