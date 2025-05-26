package com.kawunus.habityou.utils.converters

import androidx.room.TypeConverter
import java.time.LocalDate

object DatabaseConverter {

    @TypeConverter
    fun fromDateStamp(date: String): LocalDate {
        return LocalDate.parse(date)
    }

    @TypeConverter
    fun toDateStamp(date: LocalDate): String {
        return date.toString()
    }
}
