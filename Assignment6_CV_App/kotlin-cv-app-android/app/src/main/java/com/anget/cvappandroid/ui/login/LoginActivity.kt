package com.anget.cvappandroid.ui.login

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.anget.cvappandroid.MainActivity
import com.anget.cvappandroid.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

//    private val user = User("Alagie F","Nget","anget@yahoo.com","12345")
//    private val user = User(Address("Austin", "USA", "13301 Center Lake Dr" ),"anget@yahoo.com", "Alagie F Nget","Full Stack Engineer")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    }

    fun signIn(view: View){
        val email = et_email.text.toString().trim()
        val password = et_password.text.toString().trim()

        if(email == "anget@yahoo.com" && password == "12345"){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else{
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_LONG).show()
        }
    }

    fun signUp(view: View) {
//        startActivity(Intent(this, RegisterActivity::class.java))
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun onForgetPasswordClick(view: View) {
        val email = et_email.text.toString().trim()
        val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL, email)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Forgot Password from MDP Course")
        intent.putExtra(
            Intent.EXTRA_TEXT, "Forgot Password from Mobile Device Programming Course, " +
                "for resetting use this code: 12345.");
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
}