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
import com.example.maintenanceapp.databinding.FragmentWorkOrdersAddBinding
import com.example.maintenanceapp.databinding.FragmentWorkOrdersBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class WorkOrderFragmentAdd : Fragment() {

    private lateinit var workOrderAddViewModel: WorkOrderAddViewModel
    private val logTag = "WorkOrderFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_work_orders becomes FragmentWorkOrdersBinding
        val binding = DataBindingUtil.inflate<FragmentWorkOrdersAddBinding>(
            inflater,
            R.layout.fragment_work_orders_add,
            container,
            false
        )
        // add button
        val fab: FloatingActionButton = binding.update
        fab.setOnClickListener { view ->
            Log.d(logTag,"Floating button pressed")
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        return binding.root
    }
}