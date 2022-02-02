package com.radhio.therumour.db

import androidx.room.TypeConverter
import com.radhio.therumour.models.Source

/**
 * Created by Azmia Hoque Radhio on 2/2/2022.
 */
class Convertors {
    @TypeConverter
    fun fromSourceToString(source : Source) : String = source.name

    @TypeConverter
    fun fromStringToSource(source: String) : Source = Source(source,source)
}