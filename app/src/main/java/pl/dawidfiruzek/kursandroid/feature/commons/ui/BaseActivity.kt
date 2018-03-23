package pl.dawidfiruzek.kursandroid.feature.commons.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    abstract val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        ButterKnife.bind(this)
    }

    fun <T> startActivity(activityClass: Class<T>) where T : BaseActivity {
        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}