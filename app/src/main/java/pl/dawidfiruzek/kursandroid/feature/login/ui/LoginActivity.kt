package pl.dawidfiruzek.kursandroid.feature.login.ui

import android.os.Bundle
import android.widget.Toast
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @Inject
    lateinit var presenter: LoginContract.Presenter

    override val layoutId: Int =
            R.layout.activity_login

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }

    override fun onResume() {
        super.onResume()
        presenter.visible()
    }

    override fun onPause() {
        super.onPause()
        presenter.hidden()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
