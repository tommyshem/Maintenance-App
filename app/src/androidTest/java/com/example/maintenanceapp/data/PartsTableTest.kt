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
    private lateinit var partsDao: PartsDao
    private lateinit var database: AppDatabase

    // TODO the table id is auto number so the insertUsers needs to be changed from 2 args to one arg
    private val part1 = PartsEntity(1, "13-45", "nut", 4F, "washer", 1, "23")
    private val part2 = PartsEntity(2, "54-45", "bearing", 10F, "cutting table", 2, "45")

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

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        database.close()
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun getAllParts() {
        assertThat(partsDao.getAllParts()).contains("54-45")
    }

    @Test
    @Throws(Exception::class)
    fun getPartNameFromManufactureID() {
        assertThat(partsDao.getPartNameFromManufactureID("54-45")).isEqualTo("bearing")
    }
}