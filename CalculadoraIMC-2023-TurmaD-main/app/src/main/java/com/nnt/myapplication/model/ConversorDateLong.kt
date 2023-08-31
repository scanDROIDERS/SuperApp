package com.nnt.myapplication.model

import androidx.room.TypeConverter
import java.util.Date

object ConversorDateLong {
    @TypeConverter
    fun converteParaDate(dateLong: Long?) : Date? {
        return if(dateLong != null) Date(dateLong) else null
    }

    @TypeConverter
    fun deDate(date: Date?) : Long? {
        return date?.time
    }
}