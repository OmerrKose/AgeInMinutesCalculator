package com.example.ageinminutescalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener{view->
            clickDatePicker(view)

        }
    }

    private fun clickDatePicker(view: View){
        val myCalendar = Calendar.getInstance()
        val myYear = myCalendar.get(Calendar.YEAR)
        val myMonth = myCalendar.get(Calendar.MONTH)
        val myDayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this, { view, year, month, day ->
                Toast.makeText(this, "Picker Works", Toast.LENGTH_LONG).show()
            }
            , myYear
            , myMonth
            , myDayOfMonth
        ).show()
    }
}