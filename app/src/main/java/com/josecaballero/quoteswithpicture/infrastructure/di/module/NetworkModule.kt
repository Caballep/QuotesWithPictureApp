package com.josecaballero.quoteswithpicture.infrastructure.di.module

import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.Quotable.QuotableService
import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.pexels.PexelsService
import com.josecaballero.quoteswithpicture.infrastructure.di.PexelsRetrofitQualifier
import com.josecaballero.quoteswithpicture.infrastructure.di.QuotableRetrofitQualifier
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @PexelsRetrofitQualifier
    @Provides
    @Singleton
    fun providePexelsRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.pexels.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providePexelsService(@PexelsRetrofitQualifier retrofit: Retrofit): PexelsService {
        return retrofit.create(PexelsService::class.java)
    }

    @QuotableRetrofitQualifier
    @Provides
    @Singleton
    fun provideQuotableRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.quotable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideQuotableService(@QuotableRetrofitQualifier retrofit: Retrofit): QuotableService {
        return retrofit.create(QuotableService::class.java)
    }

}
