package com.josecaballero.quoteswithpicture.infrastructure.di.module

import android.content.Context
import coil.ImageLoader
import coil.request.ImageRequest
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ImageModule {

    @Provides
    @Singleton
    fun provideImageLoader(@ApplicationContext context: Context): ImageLoader {
        return ImageLoader.Builder(context)
            .build()
    }

    @Provides
    @Singleton
    fun provideImageRequestFactory(@ApplicationContext context: Context): ImageRequest.Builder {
        return ImageRequest.Builder(context)
    }
}
