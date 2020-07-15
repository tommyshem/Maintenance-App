package com.example.maintenanceapp.ui.inventoryItems

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InventoryItemsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Inventory Items Fragment"
    }
    val text: LiveData<String> = _text
}