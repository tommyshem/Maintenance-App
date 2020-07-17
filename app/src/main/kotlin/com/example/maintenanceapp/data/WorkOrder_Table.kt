package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Describe the sqlite users table
@Entity(tableName = "work_order_table")
data class WorkOrder_Table (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo( name = "work_order_number") @NonNull val workOrderNumber : Int,
    @ColumnInfo( name = "date") @NonNull val Date: String,
    @ColumnInfo( name = "summary_issue") @NonNull val summaryIssue: String,
    @ColumnInfo( name = "work_done") val workDone: String?,
    @ColumnInfo( name = "status") @NonNull val status: String,
    @ColumnInfo( name = "estimated_time") val estimatedTime: Int = 0,
    @ColumnInfo( name = "labour_time") val labourTime : Int = 0,
    @ColumnInfo ( name = "engineer_name") val Engineer_Name: String?,
    @ColumnInfo( name = "date_completed") val dateCompleted : String?,
    @ColumnInfo( name = "images_url") val imagesURL : String,
    @ColumnInfo( name = "last_modified_date") @NonNull val lastModifiedDate : String,
    @ColumnInfo( name = "parts_used") val partsUsed : String?,
    @ColumnInfo( name = "parts_required") val partsRequired : String?
    )

// Functions to interact with sqlite users table