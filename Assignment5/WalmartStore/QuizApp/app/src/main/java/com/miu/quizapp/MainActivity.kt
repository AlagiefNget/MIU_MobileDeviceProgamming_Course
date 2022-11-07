package com.miu.quizapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var groupOne: RadioGroup
    private lateinit var groupTwo: RadioGroup
    private var result: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groupOne = findViewById(R.id.question_one_radio)
        groupTwo = findViewById(R.id.question_two_radio)
    }

    fun questionOneRadioButtonClicked(view: View) {
        // correct answer: true - a
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_question1_a ->
                    if (checked) {
                        result +=50
                    }
            }
        }
    }

    fun questionTwoRadioButtonClicked(view: View) {
        // correct answer: false - b
        if (view is RadioButton) {
            val checked = view.isChecked
            when (view.getId()) {
                R.id.radio_question2_b ->
                    if (checked) {
                        result +=50
                    }
            }
        }
    }

    fun resetAnswer(view: View){
        groupOne.clearCheck()
        groupTwo.clearCheck()
    }

    private fun showResultDialog(title: String, message: String){
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("OK")
                { dialog, _ ->
                    result = 0
                    dialog.dismiss()
                }
            }
            builder.setMessage(message)
                .setTitle(title)
            builder.create()
        }
        alertDialog.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun submitAnswer(view: View) {
            val current = LocalDateTime.now()

            val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")

            val date = current.format(dateFormatter)
            val time = current.format(timeFormatter)
            val message = if(result > 0)
                "Congratulations! You submitted on current $date and $time, Your achieved $result%"
            else "Please, try again."
            val title = "QuizApp Result"
            showResultDialog(title, message)
        }
    }