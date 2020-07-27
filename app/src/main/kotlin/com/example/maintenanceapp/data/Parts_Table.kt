package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.*

// Describe the sqlite users table
@Entity(tableName = "parts_table")
data class PartsEntity (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "supplier_name") val supplierName: String,
    @ColumnInfo(name = "supplier_part_number") val supplierPartNumber: String,
    @ColumnInfo( name = "part_name") @NonNull val partName: String,
    @ColumnInfo( name = "description_of_part") @NonNull val descriptionOfPart : String,
    @ColumnInfo( name = "stock_location") val stock_location : String,
    @ColumnInfo( name = "type_of_part") val typeOfPart : String,
    @ColumnInfo( name = "qty_on_hand") val qtyOnHand : Int,
    @ColumnInfo( name = "manufacturer_name")  val manufacturerName : String,
    @ColumnInfo( name = "manufacturer_part_id")  val manufacturerPartID : String,
    @ColumnInfo( name = "parts_fit_on_machine") val partFitsOnMachine: String,
    @ColumnInfo( name = "price") val partPrice: Float,
    @ColumnInfo( name = "part_image_url") val partImageURL: String,
    @ColumnInfo( name = "last_modified_date") @NonNull val lastModifiedDate : String
)

// Functions to interact with sqlite users table
@Dao
interface PartsDao{

    @Query("SELECT * FROM parts_table ORDER BY part_name ASC")
    fun getAllParts():List<PartsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPart( vararg : PartsEntity )

    @Query("SELECT part_name FROM parts_table WHERE manufacturer_part_id = :id")
    fun getPartNameFromManufacturerID(id:String):String

    @Query("SELECT part_name FROM parts_table WHERE supplier_part_number = :id")
    fun getPartNameFromSupplierID(id:String):String

    @Query("SELECT id FROM parts_table WHERE part_name = :name")
    fun getIDFromPartName(name:String):Int
    //TODO: add delete function
}