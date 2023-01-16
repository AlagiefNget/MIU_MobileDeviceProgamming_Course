package com.example.quizapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Int = 0,
    @ColumnInfo(name = "name") val userName: String?,
    @ColumnInfo(name = "total_questions") var totalQuestions: String?,
    @ColumnInfo(name = "score") var score: String?
)