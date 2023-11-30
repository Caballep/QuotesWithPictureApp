package com.josecaballero.quoteswithpicture.infrastructure.di.module

import android.content.Context
import com.josecaballero.quoteswithpicture.MainActivity
import com.josecaballero.quoteswithpicture.QuotesWithPictureApplication
import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.Quotable.QuotableService
import com.josecaballero.quoteswithpicture.feature.main.data.sources.remote.rest.pexels.PexelsService
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApplicationModule {
    @Provides
    fun provideApplicationContext(application: QuotesWithPictureApplication): Context =
        application.applicationContext
}

//@InstallIn(ApplicationComponent::class)
//@Singleton
//@Component(modules = [
//    ApplicationModule::class,
//    NetworkModule::class
//])
//interface ApplicationComponent {
//    fun inject(activity: MainActivity)
//}
