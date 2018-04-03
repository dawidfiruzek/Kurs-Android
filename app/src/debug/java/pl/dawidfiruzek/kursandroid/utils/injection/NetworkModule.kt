package pl.dawidfiruzek.kursandroid.utils.injection

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule : BaseNetworkModule() {

    @Provides
    fun chuckInterceptor(context: Context): Interceptor =
            ChuckInterceptor(context)

    @Singleton
    @Provides
    fun okHttpClient(interceptor: Interceptor): OkHttpClient =
            OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
}
