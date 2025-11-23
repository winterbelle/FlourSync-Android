package com.example.floursync.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//generates a SQLiteDB
@Database(
    entities = [Employee::class, Product::class],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun EmployeeDao(): EmployeeDao
    abstract fun ProductDao(): ProductDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "floursync_db"
                ).fallbackToDestructiveMigration()
                    .build()
            }
    }
}