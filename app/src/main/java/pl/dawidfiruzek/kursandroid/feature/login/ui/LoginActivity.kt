package pl.dawidfiruzek.kursandroid.feature.login.ui

import android.os.Bundle
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override val layoutId: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }
}
