package com.example.ageinminutescalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDatePicker.setOnClickListener { view ->
            clickDatePicker(view)
        }
    }

    private fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val myYear = myCalendar.get(Calendar.YEAR)
        val myMonth = myCalendar.get(Calendar.MONTH)
        val myDayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(
            this, { _, selectedYear, selectedMonth, selectedDay ->
                Toast.makeText(this, "Date Picked", Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                // divide by 60000 to convert date into minutes
                val selectedDateInMinutes =
                    (simpleDateFormat.parse(selectedDate))!!.time / 60000
                val currentDateInMinutes =
                    (simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis())))!!.time / 60000

                // divide by 86400 to convert date into days
                val selectedDateInDays =
                    (simpleDateFormat.parse(selectedDate))!!.time / 86400000
                val currentDateInDays =
                    (simpleDateFormat.parse(simpleDateFormat.format(System.currentTimeMillis())))!!.time / 86400000

                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                val differenceInDays = currentDateInDays - selectedDateInDays

                tvSelectedDate.text = selectedDate
                tvSelectedDateInMinutes.text = differenceInMinutes.toString()
                tvSelectedDateInDays.text = differenceInDays.toString()

            }, myYear, myMonth, myDayOfMonth
        )

        datePicker.datePicker.maxDate =
            Date().time - 86400000 // don't display future time in the date picker
        datePicker.show()
    }
}