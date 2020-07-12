package com.example.maintenanceapp.ui.PMCheckLists

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.maintenanceapp.R

class PMCheckListsFragment : Fragment() {

    private lateinit var PMCheckListsModel: PMCheckListsModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        PMCheckListsModel =
                ViewModelProviders.of(this).get(PMCheckListsModel::class.java)
        val root = inflater.inflate(R.layout.fragment_pm_check_lists, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        PMCheckListsModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}