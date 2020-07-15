package com.example.maintenanceapp.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentUsersBinding
import com.example.maintenanceapp.ui.inventoryItems.UsersViewModel

class UsersFragment : Fragment() {

    private lateinit var usersItemsViewModel: UsersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_users, container, false)
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_users becomes FragmentUsersBinding
        val bind: FragmentUsersBinding = FragmentUsersBinding.bind(root)
        return root
    }
}