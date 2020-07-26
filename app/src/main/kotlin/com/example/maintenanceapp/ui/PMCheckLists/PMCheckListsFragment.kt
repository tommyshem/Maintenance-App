package com.example.maintenanceapp.ui.PMCheckLists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentPmCheckListsBinding
import com.example.maintenanceapp.databinding.FragmentUsersBinding

class PMCheckListsFragment : Fragment() {

    private lateinit var pmCheckListsViewModel: PMCheckListsModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_pm_check_lists becomes FragmentPmCheckListsBinding
        val binding = DataBindingUtil.inflate<FragmentPmCheckListsBinding>(inflater,R.layout.fragment_pm_check_lists,container,false)
        return binding.root
    }
}