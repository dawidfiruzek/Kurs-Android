package pl.dawidfiruzek.kursandroid.utils.injection

import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.utils.configuration.Configuration
import pl.dawidfiruzek.kursandroid.utils.configuration.ConfigurationImpl

@Module
class ConfigurationModule {

    @Provides
    fun configuration(): Configuration =
            ConfigurationImpl()
}