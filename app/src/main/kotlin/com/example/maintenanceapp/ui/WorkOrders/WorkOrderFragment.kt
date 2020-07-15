package com.example.maintenanceapp.ui.WorkOrders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentWorkOrdersBinding

class WorkOrderFragment : Fragment() {

    private lateinit var workOrderViewModel: WorkOrderViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_work_orders, container, false)
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_work_orders becomes FragmentWorkOrdersBinding
        val bind: FragmentWorkOrdersBinding = FragmentWorkOrdersBinding.bind(root)
        return root
    }
}