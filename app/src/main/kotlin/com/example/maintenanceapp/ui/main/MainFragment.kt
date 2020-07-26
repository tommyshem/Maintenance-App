package com.example.maintenanceapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentMainMenuBinding


class MainFragment : Fragment() {

    private val logTag = "MainFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(logTag,"onCreateView called")
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_users becomes FragmentUsersBinding
        //val bind: FragmentUsersBinding = FragmentUsersBinding.bind(fragmentView)
        val binding = DataBindingUtil.inflate<FragmentMainMenuBinding>(inflater,R.layout.fragment_main_menu,container,false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag,"onStart called")
    }

}