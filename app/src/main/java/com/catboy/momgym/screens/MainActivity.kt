package com.catboy.momgym.screens

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.catboy.momgym.R
import com.catboy.momgym.presenters.MainPresenter

class MainActivity : AppCompatActivity(){

    private var presenter: MainPresenter? = null
    private var hourView: TextView? = null
    private var minutesView: TextView? = null
    private var button: Button? = null
    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(applicationContext)

        image = findViewById(R.id.image)
        val timeGymText: TextView = findViewById(R.id.time_gym_text)
        val timeLayout: LinearLayout = findViewById(R.id.time_layout)
        hourView = findViewById(R.id.hours)
        val hourText: TextView = findViewById(R.id.hour_text)
        val minuteText: TextView = findViewById(R.id.minutes_text)
        minutesView = findViewById(R.id.minutes)
        button = findViewById(R.id.switch_button)

        timeGymText.setOnClickListener { timePickerDialog() }
        timeLayout.setOnClickListener { timePickerDialog() }
        hourView!!.setOnClickListener { timePickerDialog() }
        hourText.setOnClickListener { timePickerDialog() }
        minutesView!!.setOnClickListener { timePickerDialog() }
        minuteText.setOnClickListener { timePickerDialog() }
        button!!.setOnClickListener {
            presenter!!.changeIsActive()
            button!!.text = presenter!!.getButtonText()
            image!!.setImageResource(presenter!!.getImage())
            presenter!!.setOrCancelAlarm()
        }
    }
    override fun onResume() {
        super.onResume()
        presenter!!.checkIsPermissionsDenied()
        hourView!!.text = presenter!!.getHourText()
        minutesView!!.text = presenter!!.getMinutesText()
        button!!.text = presenter!!.getButtonText()
        image!!.setImageResource(presenter!!.getImage())
    }

    private fun timePickerDialog() {
        val builder = AlertDialog.Builder(this)

        builder.setPositiveButton(resources.getString(R.string.ok)) {
                dialog: DialogInterface, _: Int ->
            val alertDialog = dialog as AlertDialog
            val hourEdit: EditText = alertDialog.findViewById(R.id.hours_edit_text)
            val minuteEdit: EditText = alertDialog.findViewById(R.id.minutes_edit_text)
            val hour = presenter!!.getValidHours(hourEdit.text)
            val minutes = presenter!!.getValidMinutes(minuteEdit.text)
            hourView!!.text = hour
            minutesView!!.text = minutes
            presenter!!.saveHours(hour)
            presenter!!.saveMinutes(minutes)
            presenter!!.setOrCancelAlarm()

        }
        builder.setNegativeButton(resources.getString(R.string.cancel)) { _: DialogInterface, _: Int -> }

        val viewDialog = layoutInflater.inflate(R.layout.time_dialog, null)
        val hours: EditText = viewDialog.findViewById(R.id.hours_edit_text)
        val minutes: EditText = viewDialog.findViewById(R.id.minutes_edit_text)
        hours.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) hours.setText("")
        }
        minutes.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) minutes.setText("")
        }
        builder.setView(viewDialog)
        val dialog = builder.create()
        dialog.show()
    }
}