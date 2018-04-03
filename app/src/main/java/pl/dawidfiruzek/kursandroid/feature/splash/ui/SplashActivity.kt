package pl.dawidfiruzek.kursandroid.feature.splash.ui

import android.os.Bundle
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import timber.log.Timber
import javax.inject.Inject

class SplashActivity : BaseActivity() {

    @Inject
    lateinit var presenter: SplashContract.Presenter

    override val layoutId: Int =
            R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("message")
        presenter.initialize()
    }

    override fun onResume() {
        super.onResume()
        presenter.visible()
    }

    override fun onPause() {
        super.onPause()
        presenter.hidden()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }
}