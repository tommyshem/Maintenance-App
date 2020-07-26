package com.example.maintenanceapp.ui.users

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentUsersAddBinding
import com.example.maintenanceapp.databinding.FragmentUsersBinding

class UsersAddFragment : Fragment(){


    private lateinit var usersAddViewModel: UsersViewAddModel
    private val logTag = "UsersAddFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(logTag,"onCreateView called")
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_users_add becomes FragmentUsersAddBinding
        val binding = DataBindingUtil.inflate<FragmentUsersAddBinding>(inflater,R.layout.fragment_users_add,container,false)
        // create on click listener for drop down widget

        return binding.root
    }

}