package com.example.quizapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "title") val questionText: String,
    @ColumnInfo(name = "alternatives")
    val alternatives: ArrayList<String>,
    @ColumnInfo(name = "correct_answer") val correctAnswerIndex: Int,
)
