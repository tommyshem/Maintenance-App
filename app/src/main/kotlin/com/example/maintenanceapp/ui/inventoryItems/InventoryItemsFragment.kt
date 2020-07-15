package com.example.maintenanceapp.ui.inventoryItems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentInventoryItemsBinding

class InventoryItemsFragment : Fragment() {

    private lateinit var inventoryItemsViewModel: InventoryItemsViewModel

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
        return root
    }
}