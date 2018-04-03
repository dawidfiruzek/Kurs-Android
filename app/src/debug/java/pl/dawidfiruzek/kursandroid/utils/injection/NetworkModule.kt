package pl.dawidfiruzek.kursandroid.utils.injection

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient =
            OkHttpClient()
}
