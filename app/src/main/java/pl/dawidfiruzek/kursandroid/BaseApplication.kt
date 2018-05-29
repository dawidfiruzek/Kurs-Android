package pl.dawidfiruzek.kursandroid

import android.app.Activity
import android.app.Application
import com.amplitude.api.Amplitude
import com.crashlytics.android.Crashlytics
import com.orhanobut.hawk.Hawk
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.fabric.sdk.android.Fabric
import pl.dawidfiruzek.kursandroid.utils.injection.DaggerAppComponent
import javax.inject.Inject

abstract class BaseApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        Fabric.with(this, Crashlytics())
        Amplitude.getInstance().initialize(this, BuildConfig.AMPLITUDE_KEY)
        initTimber()
        initDaggerComponent()
    }

    abstract fun initTimber()

    private fun initDaggerComponent() {
        DaggerAppComponent.builder()
                .bindApplication(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =
            activityInjector
}