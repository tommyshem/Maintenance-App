package com.example.maintenanceapp.data

import android.content.Context
import org.junit.Before
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4

@RunWith(AndroidJUnit4::class)
class UsersTableTest {
    private lateinit var usersDao: UsersDao
    private lateinit var db :Users_Table
    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContent<Context>()

    }
}