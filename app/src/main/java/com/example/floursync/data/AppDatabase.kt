package com.example.floursync.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//generates a SQLiteDB using the entities (tables) listed.
@Database(
    entities = [Employee::class, Product::class],
    version = 1,
    exportSchema = false //schema files do not need to be saved.
)

//lets room generate DAO code.
abstract class AppDatabase : RoomDatabase() {
    abstract fun EmployeeDao(): EmployeeDao
    abstract fun ProductDao(): ProductDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { //if instance is null create db else return existing db
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "floursync_db" //the name of the .db file
                ).fallbackToDestructiveMigration() //if schema changes, this deleted the old db and builds a new one.
                    .build()
                    .also { instance = it }  // Save the instance
            }
    }
}
