package pl.dawidfiruzek.kursandroid.feature.splash.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import pl.dawidfiruzek.kursandroid.feature.splash.navigation.SplashRouter
import pl.dawidfiruzek.kursandroid.feature.splash.presentation.SplashPresenter

class SplashActivity : AppCompatActivity(), SplashContract.View {

    private lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SplashPresenter(
                this,
                SplashRouter()
        )
        presenter.initialize()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.clear()
    }
}