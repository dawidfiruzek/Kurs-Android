package pl.dawidfiruzek.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.Configuration
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.ConfigurationImpl

@Module
class ConfigurationModule {

    @Provides
    fun configuration(): Configuration =
            ConfigurationImpl()
}