package com.josecaballero.quoteswithpicture.feature.main.data.sources.local.sql

import androidx.room.TypeConverter
import java.util.Date

class DefaultConverter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}
