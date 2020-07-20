package com.example.maintenanceapp.ui.users

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentUsersAddBinding

class UsersAddFragment : Fragment(){


    private lateinit var usersItemsViewModel: UsersViewModel
    private val logTag = "UsersAddFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(logTag,"onCreateView called")
        val fragmentView = inflater.inflate(R.layout.fragment_users_add, container, false)
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_users_add becomes FragmentUsersAddBinding
        val bind: FragmentUsersAddBinding = FragmentUsersAddBinding.bind(fragmentView)
        // create on click listener for drop down widget

        return fragmentView
    }

}