package com.example.maintenanceapp.ui.inventoryItems

import android.icu.util.Calendar
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.data.AppDatabase
import com.example.maintenanceapp.databinding.FragmentInventoryItemsAddBinding
import com.example.maintenanceapp.dialog.DatePickerFragment
import com.example.maintenanceapp.utils.LimitDecimalDigits
import com.google.android.material.floatingactionbutton.FloatingActionButton


class InventoryItemsAddFragment : Fragment() {

    private lateinit var inventoryItemsAddViewModel: InventoryItemsAddViewModel
    private val logTag = "InventoryItemsAddFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(logTag, "onCreateView called")
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_inventry_items becomes FragmentInventoryItemsBinding
        val binding = DataBindingUtil.inflate<FragmentInventoryItemsAddBinding>(
            inflater,
            R.layout.fragment_inventory_items_add,
            container,
            false
        )

        // update button click
        val fab: FloatingActionButton = binding.updatePart
        fab.setOnClickListener { view ->
            Log.d(logTag, "Floating update button pressed")
        }
        // display the options menu
        setHasOptionsMenu(true)

        // TODO: datasource data binding
        val application = requireNotNull(this.activity).application
        // val arguments = SleepQualityFragmentArgs.fromBundle(arguments)
        // Create an instance of the ViewModel Factory.
        val dataSource = AppDatabase.getAppDataBase(application)?.getPartsDao()
    // limit price to 2 decimal places
        binding.editTextPrice.setFilters(arrayOf<InputFilter>(LimitDecimalDigits(6, 2)))
        // return the fragment view
        return binding.root
    }

    // create options menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu_parts, menu)
    }

    // display the calendar fragment picker
    fun showDatePicker() {
        val now = Calendar.getInstance()
        val currentYear: Int = now.get(Calendar.YEAR)
        val currentMonth: Int = now.get(Calendar.MONTH)
        val currentDay: Int = now.get(Calendar.DAY_OF_MONTH)

        val newFragment: DialogFragment = DatePickerFragment()
        newFragment.show(requireActivity().supportFragmentManager, "datePicker")
    }
}