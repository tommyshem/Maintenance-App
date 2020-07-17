package com.example.maintenanceapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
// add table entity's you want in the database
    entities = [UsersEntity::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    // Add here the table data access object
    abstract fun getUsersDao(): UsersDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "MaintenanceApp.db"
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyDataBase() {
            // close the database
            if (INSTANCE?.isOpen == true) {
                INSTANCE?.close()
            }
            // clear the reference
            INSTANCE = null
        }
    }
}