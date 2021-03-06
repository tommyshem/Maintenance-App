package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.*

// Describe the sqlite users table
@Entity(tableName = "image_url_table")
data class ImageURLEntity (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo( name = "work_order_number") @NonNull val workOrderNumber : Int,
    @ColumnInfo( name = "image_name") @NonNull val imageName: String,
    @ColumnInfo( name = "last_modified_date") @NonNull val lastModifiedDate : String
)


// Functions to interact with sqlite users table
@Dao
interface ImageURLDao{
    @Query("Select * from machines_table ORDER BY machine_name ASC")
    fun getAllImageURL():List<UsersEntity>

    // TODO the table id is auto number so the insertUsers needs to be changed from 2 args to one arg
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertImageURL( vararg : UsersEntity )

    @Query("Select machine_name from machines_table WHERE id = :id")
    fun getMachineNameFromID(id:Int):String

    @Query("Select id from machines_table WHERE machine_name = :name")
    fun getIDFromMachineName(name:String):Int
}