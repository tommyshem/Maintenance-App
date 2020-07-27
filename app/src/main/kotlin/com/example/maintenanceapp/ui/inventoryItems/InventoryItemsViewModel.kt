package com.example.maintenanceapp.ui.inventoryItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maintenanceapp.data.PartsDao


class InventoryItemsViewModel : ViewModel() {
    //val nights = PartsDao
    private val _text = MutableLiveData<String>().apply {
        value = "This is Inventory Items Fragment"
    }
    val text: LiveData<String> = _text
}