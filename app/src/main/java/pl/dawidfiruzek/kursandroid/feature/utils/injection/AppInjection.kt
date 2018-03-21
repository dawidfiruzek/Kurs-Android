package pl.dawidfiruzek.kursandroid.feature.utils.injection

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import pl.dawidfiruzek.kursandroid.BaseApplication
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    fun context(app: Application): Context =
            app
}

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBinderModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindApplication(app: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: BaseApplication)
}