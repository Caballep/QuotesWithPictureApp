package com.josecaballero.quoteswithpicture.infrastructure.di.module

import android.content.Context
import com.josecaballero.quoteswithpicture.QuotesWithPictureApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideApplicationContext(application: QuotesWithPictureApplication): Context =
        application.applicationContext
}
