package com.example.maintenanceapp.data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import androidx.room.Database

@Database(
entities = [Users_Table::class]
)
class DatabaseHandler (context: Context) {

    companion object {
        // If you change the database schema, you must increment the database version.
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MaintenanceApp.db"
    }
}