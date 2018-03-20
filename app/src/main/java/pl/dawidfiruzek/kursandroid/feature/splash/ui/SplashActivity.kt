package pl.dawidfiruzek.kursandroid.feature.splash.ui

import android.os.Bundle
import android.widget.ImageView
import butterknife.BindView
import butterknife.OnClick
import pl.dawidfiruzek.kursandroid.R
import pl.dawidfiruzek.kursandroid.feature.commons.ui.BaseActivity
import pl.dawidfiruzek.kursandroid.feature.splash.SplashContract
import timber.log.Timber

class SplashActivity : BaseActivity(), SplashContract.View {

    @BindView(R.id.splash_image)
    lateinit var splashImage: ImageView

    override val layoutId: Int =
            R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.d("message")
    }

    @OnClick(R.id.splash_image)
    fun imageClicked() {
        splashImage.animate()
                .rotation(180.0f)
                .start()
    }
}