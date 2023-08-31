package com.nnt.myapplication.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Calculo::class], version = 1)
@TypeConverters(ConversorDateLong::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calcDao() : CalculoDao

    companion object {
        private var INSTACE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            return if(INSTACE == null) {
                synchronized(this) {
                    INSTACE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "calculadora_fitness"
                    ).build()
                }
                INSTACE as AppDatabase
            } else {
                INSTACE as AppDatabase
            }
        }
    }
}

