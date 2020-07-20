package com.example.maintenanceapp.ui.inventoryItems

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.component1
import androidx.core.graphics.component2
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentInventoryItemsBinding
import com.google.android.material.datepicker.MaterialDatePicker

class InventoryItemsFragment : Fragment() {

    private lateinit var inventoryItemsViewModel: InventoryItemsViewModel
    private val logTag = "InventoryItemsFragment"

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_inventory_items, container, false)
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_inventry_items becomes FragmentInventoryItemsBinding
        val bind: FragmentInventoryItemsBinding = FragmentInventoryItemsBinding.bind(root)


        val now = Calendar.getInstance()
        val currentYear: Int = now.get(Calendar.YEAR)
        val currentMonth: Int = now.get(Calendar.MONTH)
        val currentDay: Int = now.get(Calendar.DAY_OF_MONTH)

        //val builder : MaterialDatePicker.Builder<*> = MaterialDatePicker.Builder.datePicker() // 1
        //val picker : MaterialDatePicker<*> = builder.build()  // 2
        //picker.show(supportFragmentManager, picker.toString())   // 3


        val builder  = MaterialDatePicker.Builder.datePicker()
       // val currentTimeInMillis = Calendar.getInstance().timeInMillis
        builder.setTitleText("Select Date")
       // builder.setSelection(currentTimeInMillis)
       // builder.setSelection(androidx.core.util.Pair(now.timeInMillis, now.timeInMillis)
        val picker  = builder.build()

        picker.addOnCancelListener {
            Log.d(logTag,"addOnCancel called and dialog canceled")
        }
        picker.addOnNegativeButtonClickListener {
            Log.d(logTag,"addNegativeButton called and dialog negative button clicked")
        }
        picker.addOnDismissListener {
            Log.d(logTag,"addOnDismiss called and dialog dismissed")
        }

        picker.addOnPositiveButtonClickListener {
            val (startOfRange, endOfRange) = it   // in case date range operation
            val date = it //  single select date
            Log.d(logTag,"addOnPositive called and ok button pressed")
        }
    // show the date picker
       // picker.show(getSupportFragmentManager(), picker.toString())
        //picker.show(targetFragment,picker.toString())



        return root
    }
}