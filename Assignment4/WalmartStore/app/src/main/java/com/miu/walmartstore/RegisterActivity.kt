package com.miu.walmartstore

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnCreateAccount.setOnClickListener{
            val result = User(userFirstName.text.toString(), userLastName.text.toString(), userEmail.text.toString(), userPassword.text.toString())

            val registerIntent = intent
            registerIntent.putExtra("user", result)
            setResult(Activity.RESULT_OK, registerIntent)

            Toast.makeText(this, "Account created successfully.", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    override fun onBackPressed() {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }

}
