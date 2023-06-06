package com.catboy.momgym.screens

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.catboy.momgym.R
import com.catboy.momgym.presenters.MainPresenter

class MainActivity : AppCompatActivity() {

    private var presenter: MainPresenter? = null
    private var hourText: EditText? = null
    private var minutesText: EditText? = null
    private var button: Button? = null
    private var image: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(applicationContext)

        hourText = findViewById(R.id.hours_text)
        minutesText = findViewById(R.id.minutes_text)

        hourText!!.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                hourText!!.setText("")
            }else {
                val hours: String = presenter!!.getValidHours(hourText!!.text)
                hourText!!.setText(hours)
                presenter!!.saveHours(hours)
            }
        }

        minutesText!!.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                minutesText!!.setText("")
            }else {
                val minutes: String = presenter!!.getValidMinutes(minutesText!!.text)
                minutesText!!.setText(minutes)
                presenter!!.saveMinutes(minutes)
            }
        }

        button = findViewById(R.id.switch_button)
        image = findViewById(R.id.image)
        button!!.setOnClickListener {
            presenter!!.changeIsActive()
            button!!.text = presenter!!.getButtonText()
            image!!.setImageResource(presenter!!.getImage())
        }
    }

    override fun onResume() {
        super.onResume()
        hourText!!.setText(presenter!!.getHourText())
        minutesText!!.setText(presenter!!.getMinutesText())
        button!!.text = presenter!!.getButtonText()
        image!!.setImageResource(presenter!!.getImage())
    }

    override fun onDestroy() {
        val minutes: String = presenter!!.getValidMinutes(minutesText!!.text)
        val hours: String = presenter!!.getValidHours(hourText!!.text)
        presenter!!.saveHours(hours)
        presenter!!.saveMinutes(minutes)
        super.onDestroy()
    }
}