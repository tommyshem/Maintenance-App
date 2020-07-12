package com.example.maintenanceapp.ui.InventoryItems

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.maintenanceapp.R

class InventoryItemsFragment : Fragment() {

    private lateinit var inventoryItemsViewModel: UsersViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        inventoryItemsViewModel =
                ViewModelProviders.of(this).get(UsersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_inventory_items, container, false)
        val textView: TextView = root.findViewById(R.id.text_slideshow)
        inventoryItemsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}