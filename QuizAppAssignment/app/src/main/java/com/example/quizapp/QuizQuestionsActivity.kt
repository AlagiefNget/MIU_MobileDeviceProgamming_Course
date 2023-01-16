package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.quizapp.db.AppDatabase
import com.example.quizapp.entities.Question
import com.example.quizapp.entities.User
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuizQuestionsActivity : AppCompatActivity() {
    private var userName: String? = null
    private var user: User? = null
    private val questionDbInstance = AppDatabase.getQuestionsDaoDatabase(this);

    private val questionsList: List<Question>? = questionDbInstance?.questionsDao()?.getAll()

    private var currentQuestionIndex = 0;
    private var selectedAlternativeIndex = -1;
    private var isAnswerChecked = false;
    private var totalScore = 0;

    private var tvQuestion: TextView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var btnSubmit: Button? = null
    private var tvAlternatives: ArrayList<TextView>? = null

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionDbInstance = AppDatabase.getQuestionsDaoDatabase(this);
        val userDbInstance = AppDatabase.getUserDaoDatabase(this);

        GlobalScope.launch {
            user = intent.getStringExtra("userName")
                ?.let { userDbInstance?.userDao()?.findByName(it) }
        }
        userName = intent.getStringExtra("userName")

        tvQuestion = findViewById(R.id.tvQuestion)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        btnSubmit = findViewById(R.id.btnSubmit)
        tvAlternatives = arrayListOf(
            findViewById(R.id.optionOne),
            findViewById(R.id.optionTwo),
            findViewById(R.id.optionThree),
            findViewById(R.id.optionFour),
        )

        updateQuestion()

        btnSubmit?.setOnClickListener {
            if (!isAnswerChecked) {
                val anyAnswerIsChecked = selectedAlternativeIndex != -1
                if (!anyAnswerIsChecked) {
                    Toast.makeText(this, "Please, select an option", Toast.LENGTH_SHORT).show()
                }
                else {
                    val currentQuestion = questionsList?.get(currentQuestionIndex)
                    if (currentQuestion != null) {
                        if (selectedAlternativeIndex == currentQuestion.correctAnswerIndex) {
                            answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.correct_option_border_bg)
                            totalScore++
                        }
                        else {
                            answerView(tvAlternatives!![selectedAlternativeIndex], R.drawable.wrong_option_border_bg)
                            answerView(tvAlternatives!![currentQuestion.correctAnswerIndex], R.drawable.correct_option_border_bg)
                        }
                    }

                    isAnswerChecked = true
                    btnSubmit?.text = if (currentQuestionIndex == questionsList!!.size - 1) "FINISH" else "NEXT QUESTION"
                    selectedAlternativeIndex = -1
                }
            }
            else {
                if (currentQuestionIndex < questionsList!!.size - 1) {
                    currentQuestionIndex++
                    updateQuestion()
                }
                else {
                    val intent = Intent(this, ResultActivity::class.java)

                    intent.putExtra("userName", userName)
                    intent.putExtra("totalQuestions", questionsList.size)
                    intent.putExtra("totalScore", totalScore)
                    startActivity(intent)
                    finish()
                }

                isAnswerChecked = false
            }
        }

        tvAlternatives?.let {
            for (optionIndex in it.indices) {
                it[optionIndex].let {
                    it.setOnClickListener{
                        if (!isAnswerChecked) {
                            selectedAlternativeView(it as TextView, optionIndex)
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun updateQuestion() {
        defaultAlternativesView()

        if(!questionsList!!.isEmpty()){
            tvQuestion?.text = questionsList!![currentQuestionIndex].questionText
            progressBar?.progress = currentQuestionIndex + 1
            tvProgress?.text = "${currentQuestionIndex + 1}/${questionsList.size}"

            for (alternativeIndex in questionsList[currentQuestionIndex].alternatives.indices) {
                tvAlternatives!![alternativeIndex].text = questionsList[currentQuestionIndex].alternatives[alternativeIndex]
            }
        }

        btnSubmit?.text = if (currentQuestionIndex == questionsList.size - 1) "FINISH" else "SUBMIT"
    }

    private fun defaultAlternativesView() {
        for (alternativeTv in tvAlternatives!!) {
            alternativeTv.typeface = Typeface.DEFAULT
            alternativeTv.setTextColor(Color.parseColor("#7A8089"))
            alternativeTv.background = ContextCompat.getDrawable(
                this@QuizQuestionsActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedAlternativeView(option: TextView, index: Int) {
        defaultAlternativesView()
        selectedAlternativeIndex = index

        option.setTextColor(
            Color.parseColor("#363A43")
        )
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(view: TextView, drawableId: Int) {
        view.background = ContextCompat.getDrawable(
            this@QuizQuestionsActivity,
            drawableId
        )
        tvAlternatives!![selectedAlternativeIndex].setTextColor(
            Color.parseColor("#FFFFFF")
        )
    }
}