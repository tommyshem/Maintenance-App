package com.example.maintenanceapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns


// Define the sql table creation string from work order table definition
private const val SQL_CREATE_WORK_ORDER_ENTRIES =
    "CREATE TABLE ${WorkOrder.Table.TABLE_NAME} (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY," +
            "${WorkOrder.Table.COLUMN_DATE} TEXT," +
            "${WorkOrder.Table.COLUMN_NAME_ENGINEERS_NAME} TEXT)"

// Define the sql table deletion string to remove the table from the database
private const val SQL_DELETE_WORK_ORDER_ENTRIES = "DROP TABLE IF EXISTS ${WorkOrder.Table.TABLE_NAME}"

class DatabaseHandler (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_WORK_ORDER_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // ToDo This just deletes the database and creates a new empty version of the database
        db.execSQL(SQL_DELETE_WORK_ORDER_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        // If you change the database schema, you must increment the database version.
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "MaintenanceApp.db"
    }
}