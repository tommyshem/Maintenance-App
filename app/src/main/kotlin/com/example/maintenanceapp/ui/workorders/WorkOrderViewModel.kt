package com.example.maintenanceapp.ui.workorders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkOrderViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Work Orders Fragment"
    }
    val text: LiveData<String> = _text
}