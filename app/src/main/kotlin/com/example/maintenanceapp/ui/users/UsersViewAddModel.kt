package com.example.maintenanceapp.ui.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewAddModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Users Fragment"
    }
    val text: LiveData<String> = _text
}