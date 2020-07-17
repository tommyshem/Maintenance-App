package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.*

@Entity(tableName = "users_table")
data class Users_Table (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo( name = "engineer_name") @NonNull val workOrderNumber : String
)

@Dao
interface UsersDao{
    @Query("Select * from users_table ORDER BY engineer_name ASC")
    fun getUsers():List<Users_Table>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers( vararg : Users_Table )

    @Query("Select engineer_name from users_table WHERE id = :id")
    fun getEngineerNameFromID(id:Int):String

    @Query("Select id from users_table WHERE engineer_name = :name")
    fun getIDFromEngineerName(name:String):Int
}