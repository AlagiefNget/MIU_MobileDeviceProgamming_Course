package com.miu.walmartstore

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var userArray = arrayListOf(
        User("Natoma","Balajo","nbalajo@gmail.com","12345")
        ,User("John","Doe","jdoe@cscomouting.com","12345")
        ,User("Marcus","Gavi","mgavi@gtest.com","12345")
        ,User("Alagie F","Nget","anget@yahoo.com","12345")
        ,User("Fatou","Mbaye","fmbaye@hotmail.com","12345"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Implementation of Task 3
        signInBtn.setOnClickListener{
            val email = userEmail.text.toString()
            val password = userPassword.text.toString()

            for(user in userArray){
                if(user.userName == email && user.password == password){
                    val intent = Intent(this, ShoppingCategory::class.java)
                    intent.putExtra("userName", email)
                    startActivity(intent)
                    break
                }else{
                    Toast.makeText(this,"Invalid credentials. Please try again!", Toast.LENGTH_LONG).show()
                }
            }

        }

        //Implementation of Task 5
        val resultContracts = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
            if(result.resultCode == Activity.RESULT_OK) {
                val temp = result.data?.getSerializableExtra("user")
                val newUser = temp as User
                userArray.add(newUser)
            }
            else{
                Toast.makeText(this,"Fail to get Result!",Toast.LENGTH_LONG).show()
            }
        }

        createBtn.setOnClickListener{
            val intent = Intent(this,RegisterActivity::class.java)
            resultContracts.launch(intent)
        }

        //Implementation of task 6
        forgetPasswordTxtView.setOnClickListener{
            val email = userEmail.text.toString()
            var pwd : String? = ""
            for(user in userArray){
                if(user.userName == email){
                    pwd = user.password
                    break
                }
            }

            if(pwd != ""){
                //send email implicit intent when forget password clicked
                val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null))

                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Walmart Store Account Forgot Password")
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Your password is: $pwd")
                startActivity(Intent.createChooser(emailIntent, "Send email..."))

            }else{
                Toast.makeText(this,"User Not Found!",Toast.LENGTH_LONG).show()
            }
        }
    }
}