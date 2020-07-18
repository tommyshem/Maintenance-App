package com.example.maintenanceapp.data

import androidx.annotation.NonNull
import androidx.room.*

// Describe the sqlite users table
@Entity(tableName = "parts_table")
data class PartsEntity (
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo( name = "manufacture_part_id") @NonNull val manufacturePartID : String,
    @ColumnInfo( name = "part_name") @NonNull val partName: String,
    @ColumnInfo( name = "price") val partPrice: Float,
    @ColumnInfo( name = "machine_location") val machineLocation: String,
    @ColumnInfo( name = "part_image_id") val partImageID: Long,
    @ColumnInfo( name = "last_modified_date") @NonNull val lastModifiedDate : String
)

@Entity(tableName = "parts_images")
data class PartsImagesEntity(
    @PrimaryKey(autoGenerate = true) val partImageUrlID: Long,
    val partsEntityImageID: Long,
    val partImageSummary: String,
    val part_image_url: String
)

data class PartWithImages(
    @Embedded val parts:PartsEntity,
    @Relation (
        parentColumn = "id",
        entityColumn = "partsEntityImageID"
    )
    val partlists: List<PartsImagesEntity>
)

// Functions to interact with sqlite users table
@Dao
interface PartsDao{

    @Query("SELECT * FROM parts_table ORDER BY part_name ASC")
    fun getAllParts():List<PartsEntity>

    @Transaction
    @Query("SELECT * FROM parts_table")
    fun getPartsWithImages(): List<PartWithImages>

    // TODO the table id is auto number so the insertUsers needs to be changed from 2 args to one arg
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPart( vararg : PartsEntity )

    @Query("SELECT part_name FROM parts_table WHERE manufacture_part_id = :id")
    fun getPartNameFromManufactureID(id:String):String

    @Query("SELECT id FROM parts_table WHERE part_name = :name")
    fun getIDFromPartName(name:String):Int
}