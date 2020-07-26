package com.example.maintenanceapp.ui.workorders

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentWorkOrdersBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class WorkOrderFragment : Fragment() {

    private lateinit var workOrderViewModel: WorkOrderViewModel
    private val logTag = "WorkOrderFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_work_orders becomes FragmentWorkOrdersBinding
        val binding = DataBindingUtil.inflate<FragmentWorkOrdersBinding>(
            inflater,
            R.layout.fragment_work_orders,
            container,
            false
        )
        // add button
        val fab: FloatingActionButton = binding.fab
        fab.setOnClickListener { view ->
            Log.d(logTag,"Floating button pressed")
            view.findNavController().navigate(R.id.action_nav_work_orders_to_workOrderFragmentAdd)
        }

        return binding.root
    }
}