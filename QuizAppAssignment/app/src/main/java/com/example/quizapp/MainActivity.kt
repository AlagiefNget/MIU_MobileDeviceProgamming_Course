package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizapp.db.AppDatabase
import com.example.quizapp.entities.User
import com.example.quizapp.entities.Question
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val questionDbInstance = AppDatabase.getQuestionsDaoDatabase(this);
        val userDbInstance = AppDatabase.getUserDaoDatabase(this);

        GlobalScope.launch {
            val questionsList: ArrayList<com.example.quizapp.Question> = Constants.getQuestions()
            for(question in questionsList){
                val qst = Question(
                    questionText= question.questionText,
                    alternatives = question.alternatives,
                    correctAnswerIndex = question.correctAnswerIndex
                )

//                questionDbInstance?.questionsDao()?.insertQuestion(qst)
            }

        }

        val etName = findViewById<EditText>(R.id.etName)
        val btnStart = findViewById<Button>(R.id.btnStart)

        btnStart.setOnClickListener {
            if (etName.text.isEmpty()) {
                Toast.makeText(this, "Please, enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra("userName", etName.text.toString())
                GlobalScope.launch {
                    val user = User( userName = etName.text.toString(), totalQuestions = "0", score = "0")

                    userDbInstance?.userDao()?.insertUser(user)
                }
                startActivity(intent)
//                finish()
            }
        }
    }

}