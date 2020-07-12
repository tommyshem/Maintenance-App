package com.example.maintenanceapp.ui.PMCheckLists

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PMCheckListsModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is PM Check Lists Fragment"
    }
    val text: LiveData<String> = _text
}