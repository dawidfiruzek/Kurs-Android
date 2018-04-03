package pl.dawidfiruzek.kursandroid.feature.utils.injection

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import pl.dawidfiruzek.kursandroid.feature.utils.configuration.StringConstants
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient =
            OkHttpClient()

    @Singleton
    @Provides
    fun converterFactory(): Converter.Factory =
            GsonConverterFactory.create()

    @Singleton
    @Provides
    fun callAdapterFactory(): CallAdapter.Factory =
            RxJava2CallAdapterFactory.create()

    @Singleton
    @Provides
    fun retrofit(
            httpClient: OkHttpClient,
            converterFactory: Converter.Factory,
            callAdapterFactory: CallAdapter.Factory
    ): Retrofit =
            Retrofit.Builder()
                    .baseUrl(StringConstants.BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(converterFactory)
                    .addCallAdapterFactory(callAdapterFactory)
                    .build()
}
