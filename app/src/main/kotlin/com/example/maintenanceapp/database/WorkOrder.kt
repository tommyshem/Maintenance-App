package com.example.maintenanceapp.database

import android.content.ContentValues
import android.provider.BaseColumns
import com .example.maintenanceapp.MainActivity

import java.util.*
// Define the Work Order Table
object WorkOrder {
    // Table contents are grouped together in an anonymous object.
    object Table : BaseColumns {
        // Define Table layout
    const val TABLE_NAME ="WorkOrderTable"
    const val COLUMN_WO_NUMBER: Int = 0
    const val COLUMN_DATE: String = ""
    const val COLUMN_SUMMARY_ISSUE: String = ""
    const val COLUMN_NAME_WORK_ORDER_STATUS : String =""
    const val COLUMN_NAME_LABOUR_TIME :Int = 0
    const val COLUMN_NAME_ESTIMATED_TIME :Int = 0
    const val COLUMN_NAME_WORK_ORDER_COMPLETED_DATE : Int =0
    const val COLUMN_NAME_IMAGES : String = ""
    const val COLUMN_NAME_LAST_MODIFIED_DATE : String = ""
    const val COLUMN_NAME_PARTS_USED : String = ""
    const val COLUMN_NAME_PARTS_NEEDED : String = ""
    const val COLUMN_NAME_ENGINEERS_NAME : String = ""
    const val COLUMN_NAME_ENGINEERS_ID : String = ""


}}

// Pass in the database object and data
class WorkOrderTable(dbhelper: DatabaseHandler){
    // Gets the database in readonly mode
    val database = dbhelper

    fun insertrow(title:String,name:String){
        // get database in write mode
        val db =database.writableDatabase
        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(WorkOrder.Table.COLUMN_DATE, title)
            put(WorkOrder.Table.COLUMN_NAME_ENGINEERS_NAME, name)
        }

        // Insert the new row, returning the primary key value of the new row
        val newRowId = db?.insert(WorkOrder.Table.TABLE_NAME, null, values)

    }

    fun getDate(){
        // get database as readonly mode
        val db = database.readableDatabase
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        val projection = arrayOf(BaseColumns._ID, WorkOrder.Table.COLUMN_DATE)

        // Filter results WHERE "title" = 'My Title'
        val selection = "${WorkOrder.Table.COLUMN_NAME_ENGINEERS_NAME} = ?"
        val selectionArgs = arrayOf("Tom")

        // How you want the results sorted in the resulting Cursor
        val sortOrder = "${WorkOrder.Table.COLUMN_SUMMARY_ISSUE} DESC"

        val cursor = db.query(
            WorkOrder.Table.TABLE_NAME,     // The table to query
            projection,                     // The array of columns to return (pass null to get all)
            selection,                      // The columns for the WHERE clause
            selectionArgs,                  // The values for the WHERE clause
            null,                  // don't group the rows
            null,                   // don't filter by row groups
            sortOrder                       // The sort order
        )

    }
}