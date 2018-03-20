package pl.dawidfiruzek.kursandroid.feature.splash.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import timber.log.Timber

class SplashActivity : AppCompatActivity(), SplashContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Timber.d("message")
    }
}