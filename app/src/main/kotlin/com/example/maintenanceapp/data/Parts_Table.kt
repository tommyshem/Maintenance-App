package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Describe the sqlite users table
@Entity(tableName = "parts_table")
data class Parts_Table (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo( name = "parts_id") @NonNull val partsID : Int,
    @ColumnInfo( name = "image_name") @NonNull val imageName: String,
    @ColumnInfo( name = "last_modified_date") @NonNull val lastModifiedDate : String
)

// Functions to interact with sqlite users table