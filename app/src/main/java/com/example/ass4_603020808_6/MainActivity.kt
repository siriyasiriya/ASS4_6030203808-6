package com.example.ass4_603020808_6

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)


        btn_date.setOnClickListener {
            val dpd = DatePickerDialog(
                this,
                DatePickerDialog.OnDateSetListener { view, mYear, mMonth, mDay ->
                    text_date.setText("" + mDay + "/" + mMonth + "/" + mYear)
                },
                year,
                month,
                day
            )
            dpd.show()
        }



    }
    fun radio_button_click(view: View) {
// Get the clicked radio button instance
        val radio: RadioButton = findViewById(radioGroup.checkedRadioButtonId)
        Toast.makeText(applicationContext, "On click : ${radio.text}", Toast.LENGTH_SHORT)
            .show()
    }

    fun register(view: View) {
        val radio: RadioButton = findViewById(radioGroup.checkedRadioButtonId)
        txt_show.text =
            "Name: ${edit_name.text}\nPassword: ${edit_password.text}\nGender:${radio.text}\nEmail: ${edit_email.text}\nDate: ${text_date.text} "
    }

    fun reset(v: View) {
        edit_name.text.clear()
        edit_password.text.clear()
        radioGroup.clearCheck()
        edit_email.text.clear()
        text_date.text = "dd / mm / yyyy"
        txt_show.text = "Show information"
    }
}





