package com.example.maintenanceapp.ui.workorders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentUsersAddBinding
import com.example.maintenanceapp.databinding.FragmentWorkOrdersBinding

class WorkOrderFragment : Fragment() {

    private lateinit var workOrderViewModel: WorkOrderViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_work_orders becomes FragmentWorkOrdersBinding
        val binding = DataBindingUtil.inflate<FragmentWorkOrdersBinding>(inflater,R.layout.fragment_work_orders,container,false)
        return binding.root
    }
}