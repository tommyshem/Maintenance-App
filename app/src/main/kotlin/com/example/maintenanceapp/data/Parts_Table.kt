package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parts_table")
data class Parts_Table (
    @PrimaryKey val id: Int,
    @ColumnInfo( name = "parts_id") @NonNull val partsID : Int,
    @ColumnInfo( name = "image_name") @NonNull val Date: String
)