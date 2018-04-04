package pl.dawidfiruzek.kursandroid.utils.injection

import dagger.Module
import dagger.Provides
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsHelper
import pl.dawidfiruzek.kursandroid.utils.analytics.AnalyticsHelperImpl

@Module
class AnalyticsModule {

    @Provides
    fun analyticsHelper(): AnalyticsHelper =
            AnalyticsHelperImpl()
}
