package com.example.quizapp

data class Question(
    val id: Int,
    val questionText: String,
    val alternatives: ArrayList<String>,
    val correctAnswerIndex: Int,
)
