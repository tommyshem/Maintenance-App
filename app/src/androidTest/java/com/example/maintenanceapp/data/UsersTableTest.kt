package com.example.maintenanceapp.data.UsersTableTest

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.maintenanceapp.data.AppDatabase
import com.example.maintenanceapp.data.UsersDao
import com.example.maintenanceapp.data.UsersEntity
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class UsersTableTest {
    private lateinit var usersDao: UsersDao
    private lateinit var database: AppDatabase

    // TODO the table id is auto number so the insertUsers needs to be changed from 2 args to one arg
    private val user1 = UsersEntity(1, "John", "2020:07:16")
    private val user2 = UsersEntity(2, "tommy Jim lad", "2020:2:12")

    @Before
    fun createDatabase() {
        // set up device
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // build database in memory
        database = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java
        ).build()
        // get user table
        usersDao = database.getUsersDao()
        // insert test data
        usersDao.insertUsers(user1)
        usersDao.insertUsers(user2)
    }

    @After
    @Throws(IOException::class)
    fun closeDatabase() {
        database.close()
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun getAllUsers() {
        assertThat(usersDao.getAllUsers()).isEqualTo(listOf(user1, user2))
    }

    @Test
    @Throws(Exception::class)
    fun getEngineerNameFromID() {
        assertThat(usersDao.getEngineerNameFromID(1)).isEqualTo("John")
    }
}