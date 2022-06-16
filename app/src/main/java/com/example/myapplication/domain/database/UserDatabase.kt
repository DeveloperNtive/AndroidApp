package com.example.myapplication.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.domain.database.dao.UserDao
import com.example.myapplication.domain.database.entities.UsersEntity

@Database(
    entities = [UsersEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(UsersTypeConverter::class)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        private var db: UserDatabase? = null
        fun getDB(context: Context): UserDatabase {
            if (db == null) {
                db = Room.databaseBuilder(
                    context,
                    UserDatabase::class.java,
                    "database"
                ).build()
            }
            return db!!
        }
    }
}