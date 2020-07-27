package com.example.maintenanceapp.ui.inventoryItems

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.maintenanceapp.R
import com.example.maintenanceapp.adapter.PartsAdapter
import com.example.maintenanceapp.databinding.FragmentInventoryItemsBinding
import com.example.maintenanceapp.dialog.DatePickerFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton


class InventoryItemsFragment : Fragment() {

    private lateinit var inventoryItemsViewModel: InventoryItemsViewModel
    private val logTag = "InventoryItemsFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(logTag, "onCreateView called")
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_inventry_items becomes FragmentInventoryItemsBinding
        val binding = DataBindingUtil.inflate<FragmentInventoryItemsBinding>(
            inflater,
            R.layout.fragment_inventory_items,
            container,
            false
        )

        // add button
        val fab: FloatingActionButton = binding.addPart
        fab.setOnClickListener { view ->
            Log.d(logTag, "Floating button pressed")
            view.findNavController()
                .navigate(R.id.action_nav_inventory_items_to_inventoryItemsAddFragment)
        }

        // recycler view
        val adapter = PartsAdapter()
        binding.partsList.adapter = adapter
        // return parts view
        return binding.root
    }

    fun showDatePicker() {
        val now = Calendar.getInstance()
        val currentYear: Int = now.get(Calendar.YEAR)
        val currentMonth: Int = now.get(Calendar.MONTH)
        val currentDay: Int = now.get(Calendar.DAY_OF_MONTH)

        val newFragment: DialogFragment = DatePickerFragment()
        newFragment.show(requireActivity().supportFragmentManager, "datePicker")
    }
}