package pl.dawidfiruzek.kursandroid.feature.utils.injection

import android.support.v7.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import pl.dawidfiruzek.kursandroid.feature.splash.ui.SplashActivity

@Module
abstract class ActivityBinderModule {

    @Binds
    abstract fun activity(activity: AppCompatActivity): AppCompatActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindsSplashActivity(): SplashActivity
}