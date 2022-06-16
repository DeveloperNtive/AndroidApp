package com.example.myapplication.core

import android.app.Application
import com.example.myapplication.domain.database.UserDatabase
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltAndroidApp
class MvvmExampleApp: Application(){

    companion object{
        private var db: UserDatabase? = null
        public fun getDB(): UserDatabase {
            return db!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        db = UserDatabase.getDB(applicationContext)
    }
}