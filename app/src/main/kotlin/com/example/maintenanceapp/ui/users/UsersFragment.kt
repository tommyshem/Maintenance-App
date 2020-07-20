package com.example.maintenanceapp.ui.users

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.maintenanceapp.R
import com.example.maintenanceapp.databinding.FragmentUsersBinding

class UsersFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var usersItemsViewModel: UsersViewModel
    private val logTag = "UsersFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(logTag,"onCreateView called")
        val fragmentView = inflater.inflate(R.layout.fragment_users, container, false)
        // A binding class is generated for each layout file.
        // By default, the name of the class is based on the name of the layout file,
        // converting it to Pascal case and adding the Binding suffix to it e.g fragment_users becomes FragmentUsersBinding
        val bind: FragmentUsersBinding = FragmentUsersBinding.bind(fragmentView)
        // create on click listener for drop down widget
        bind.dropDownEngineersName.onItemSelectedListener = this

        // create a list of items for the spinner. TODO: needs changing to data contents
        var items = arrayOf<String>("Tommy Shemwell", "John Bird", "Fred Honneycone")
        // get dropdown reference
        val dropdown = bind.dropDownEngineersName
        // create an adapter to describe how the items are displayed.
        val adapter: ArrayAdapter<String?> =
            ArrayAdapter<String?>(
                requireActivity(),
                android.R.layout.simple_dropdown_item_1line,
                items
            )
        // set the dropdown adapter to the previously created adapter.
        dropdown.adapter = adapter

        return fragmentView
    }

    override fun onStart() {
        super.onStart()
        Log.d(logTag,"onStart called")
    }

    // drop down widget callback function
    override fun onNothingSelected(p0: AdapterView<*>?) {
        Log.d(logTag,"onNothingSelected called")

    }
    // drop down widget callback function
    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        Log.d(logTag,"onItemSelected called")
    }
}