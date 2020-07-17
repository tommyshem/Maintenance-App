package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.*

// Describe the sqlite users table
@Entity(tableName = "users_table")
data class UsersEntity (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo( name = "engineer_name") @NonNull val engineerName : String
)

// Functions to interact with sqlite users table
@Dao
interface UsersDao{
    @Query("Select * from users_table ORDER BY engineer_name ASC")
    fun getUsers():List<UsersEntity>

    // TODO the table id is auto number so the insertUsers needs to be chabged from 2 args to one arg
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers( vararg : UsersEntity )

    @Query("Select engineer_name from users_table WHERE id = :id")
    fun getEngineerNameFromID(id:Int):String

    @Query("Select id from users_table WHERE engineer_name = :name")
    fun getIDFromEngineerName(name:String):Int
}