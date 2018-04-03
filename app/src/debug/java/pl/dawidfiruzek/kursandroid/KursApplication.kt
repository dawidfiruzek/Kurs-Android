package pl.dawidfiruzek.kursandroid

import com.facebook.stetho.Stetho
import com.squareup.leakcanary.LeakCanary
import timber.log.Timber

class KursApplication : BaseApplication() {

    override fun onCreate() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return
        }
        LeakCanary.install(this)
        // Normal app init code...
        Stetho.initializeWithDefaults(this)
        super.onCreate()
    }

    override fun initTimber() {
        Timber.plant(Timber.DebugTree())
    }
}