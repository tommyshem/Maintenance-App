package com.example.maintenanceapp.data

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class PartsTableTest {
    // ------------- Variables for the database testing -----------------
    private lateinit var partsDao: PartsDao
    private lateinit var database: AppDatabase

    // ------- Data for testing------------------------------------------
    private val part1 = PartsEntity(
        1,
        "Alltools",
        "345-45",
        "M6 Flat washer",
        "this is a flat steel circle with a hole",
        "cabinet 23",
        "hardware",
        6,
        "gen",
        "M6 Flat washer",
        "drill",
        6.34F,
        "",
        ""
    )
    private val part2 = PartsEntity(
        2,
        "Bystronic",
        "36789N",
        "small valve",
        "this is a flat steel circle with a hole",
        "cabinet 29 - box 8",
        "valve",
        0,
        "bosch",
        "V-3438678",
        "cutting table",
        100.89F,
        "file location here",
        ""
    )

    // --------- Create the database and load the dummy data for testing -------------------------
    @Before
    fun createDatabase() {
        // set up device
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // build database in memory
        database = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        // get part table
        partsDao = database.getPartsDao()
        // insert test data
        partsDao.insertPart(part1)
        partsDao.insertPart(part2)
    }

    // ------ close the database and clean up after testing----------------------
    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        database.close()
    }

    // -------------   All parts Table Tests below ------------------------------------
    // -------------- test getAllParts function -------------------------------------
    @Test
    @Throws(java.lang.Exception::class)
    fun getAllParts() {
        assertThat(partsDao.getAllParts()).contains("Bystronic")
    }

    // ---------------- test getPartsNameFromManufacturerID function ----------------------
    @Test
    @Throws(Exception::class)
    fun getPartNameFromManufacturerID() {
        assertThat(partsDao.getPartNameFromManufacturerID("V-3438678")).isEqualTo("small valve")
    }

    // ---------------- test getIDFromPartName function ----------------------
    @Test
    @Throws(Exception::class)
    fun getIDFromPartName() {
        assertThat(partsDao.getIDFromPartName("M6 Flat washer")).isEqualTo(1)
    }

    // ---------------- test getPartNameFromSupplierID function ----------------------
    @Test
    @Throws(Exception::class)
    fun getPartNameFromSupplierID() {
        assertThat(partsDao.getPartNameFromSupplierID("36789N")).isEqualTo("small valve")
    }


}