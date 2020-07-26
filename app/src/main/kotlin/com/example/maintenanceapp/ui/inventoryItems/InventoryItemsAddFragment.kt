package com.example.maintenanceapp.ui.inventoryItems

import android.icu.util.Calendar
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentInventoryItemsAddBinding
import com.example.maintenanceapp.databinding.FragmentInventoryItemsBinding
import com.example.maintenanceapp.databinding.FragmentUsersBinding
import com.example.maintenanceapp.dialog.DatePickerFragment
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
            Log.d(logTag, "Floating button pressed")
            //  view.findNavController().navigate(R.id.action_nav_work_orders_to_workOrderFragmentAdd)
        }
        // display the options menu
        setHasOptionsMenu(true)


        return binding.root
    }

    // create options menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.options_menu_parts,menu)
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