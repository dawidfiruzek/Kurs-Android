package pl.dawidfiruzek.kursandroid.feature.login.ui

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity
import pl.dawidfiruzek.kursandroid.feature.login.LoginContract
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    @BindView(R.id.login_button)
    lateinit var loginButton: Button

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

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun getLoginClickedObservable(): Observable<Unit> =
        RxView.clicks(loginButton)
                .map { Unit }
                .subscribeOn(AndroidSchedulers.mainThread())
}
