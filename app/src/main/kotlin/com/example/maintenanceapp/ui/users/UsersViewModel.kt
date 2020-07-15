package com.example.maintenanceapp.ui.inventoryItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Users Fragment"
    }
    val text: LiveData<String> = _text
}