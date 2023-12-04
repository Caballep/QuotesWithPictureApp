package com.josecaballero.quoteswithpicture.infrastructure.di.module

import android.content.Context
import com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.AppDatabase
import com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote.ImageQuoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SQLModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase = AppDatabase.get(context)

    @Provides
    @Singleton
    fun provideImageQuoteDao(appDatabase: AppDatabase): ImageQuoteDao {
        return appDatabase.imageQuoteDao()
    }

}
