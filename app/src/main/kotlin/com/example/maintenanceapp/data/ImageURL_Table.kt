package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_url_table")
data class ImageURL_Table (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo( name = "work_order_number") @NonNull val workOrderNumber : Int,
    @ColumnInfo( name = "image_name") @NonNull val Date: String
)