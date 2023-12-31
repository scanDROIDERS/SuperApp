package com.nnt.myapplication

import android.app.Application
import com.nnt.myapplication.model.AppDatabase

class App : Application() {
    lateinit var db: AppDatabase

    override fun onCreate() {
        super.onCreate()
        db = AppDatabase.getDatabase(this)
    }
}