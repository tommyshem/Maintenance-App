package com.example.maintenanceapp.dialog

import android.app.Activity
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*


class DatePickerFragment : DialogFragment(),
    OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Use the current date as the default date in the picker
        val c: Calendar = Calendar.getInstance()
        val year: Int = c.get(Calendar.YEAR)
        val month: Int = c.get(Calendar.MONTH)
        val day: Int = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(
        datePicker: DatePicker,
        year: Int,
        month: Int,
        day: Int
    ) {
        val sessionDate =
            "$day/$month/$year/"

        Log.d("4stepsFragment", sessionDate)

        targetFragment?.onActivityResult(
            targetRequestCode,
            Activity.RESULT_OK,
            Intent().putExtra("selectedDate", sessionDate)
        )

    }
}