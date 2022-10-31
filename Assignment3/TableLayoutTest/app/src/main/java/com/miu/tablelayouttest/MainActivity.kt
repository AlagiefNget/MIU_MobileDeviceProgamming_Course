package com.miu.tablelayouttest

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn.setBackgroundColor(Color.parseColor("#CCCCCC"));

        addBtn.setOnClickListener{
            val codeTxtView = TextView(applicationContext)

            codeTxtView.setBackgroundResource(R.drawable.border)
            codeTxtView.setTextColor(R.color.black)
            codeTxtView.text = androidCodeName.text.toString()

            val versionTxtView = TextView(applicationContext)
            versionTxtView.setBackgroundResource(R.drawable.border)
            versionTxtView.setTextColor(R.color.black)
            versionTxtView.text = androidVersion.text.toString()

            val tableRow = TableRow(applicationContext)//this

            // Set new table row layout parameters.
            val layoutParams = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            tableRow.setLayoutParams(layoutParams)
            layoutParams.setMargins(0,0,0,12)

            // add values into row by calling addView()
            tableRow.addView(versionTxtView,0, layoutParams)
            tableRow.addView(codeTxtView,1, layoutParams)
            // Finally add the created row row into layout
            tableLayout.addView(tableRow, layoutParams)
            clearFields()
        }
    }

    // Helper method to clear the text fields after clicking the add button
    private fun clearFields(){
        androidCodeName.setText("")
        androidVersion.setText("")
    }
}