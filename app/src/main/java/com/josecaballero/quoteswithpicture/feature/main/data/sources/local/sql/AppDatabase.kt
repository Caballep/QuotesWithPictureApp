package com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote.ImageQuoteEntity
import com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql.imagequote.ImageQuoteDao

@Database(entities = [ImageQuoteEntity::class], version = 1)
@TypeConverters(DefaultConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun imageQuoteDao(): ImageQuoteDao

    companion object {
        fun get(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "app_database"
            ).build()
        }
    }
}
