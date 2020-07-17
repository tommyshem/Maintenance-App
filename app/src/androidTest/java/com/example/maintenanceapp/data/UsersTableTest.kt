package com.example.maintenanceapp.data.UsersTableTest

import androidx.room.Room
import org.junit.Assert.assertThat
import org.hamcrest.Matchers.equalTo
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import com.example.maintenanceapp.data.*

@RunWith(AndroidJUnit4::class)
class UsersTableTest {
    private lateinit var usersDao: UsersDao
    private lateinit var database : AppDatabase
    // TODO the table id is auto number so the insertUsers needs to be chabged from 2 args to one arg
    private val user1 = UsersEntity(1,"John")
    @Before
    fun createDb() {
        // set up device
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // build database in memory
        database = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
        // get user table
        usersDao = database.getUsersDao()
        // insert test data
        usersDao.insertUsers(user1)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

    @Test
    @Throws(java.lang.Exception::class)
    fun getalldata(){
        assertThat(usersDao.getUsers(), equalTo(listOf(user1)))
    }

    @Test
    @Throws(Exception::class)
    fun readID() {
        assertThat(usersDao.getEngineerNameFromID(1), equalTo("John"))
    }}