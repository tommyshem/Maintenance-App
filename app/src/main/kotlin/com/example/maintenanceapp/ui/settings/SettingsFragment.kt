package com.example.maintenanceapp.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentSettingsBinding
import com.example.maintenanceapp.databinding.FragmentUsersBinding


class SettingsFragment : Fragment() {

    private lateinit var settingsItemsViewModel: SettingsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_settings becomes FragmentSettingsBinding
        val binding = DataBindingUtil.inflate<FragmentUsersBinding>(inflater,R.layout.fragment_users,container,false)
        return binding.root
    }
}