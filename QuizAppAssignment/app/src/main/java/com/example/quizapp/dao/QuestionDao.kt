package com.example.quizapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.entities.Question

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question")
    fun getAll(): List<Question>

    @Query("SELECT * FROM question WHERE id IN (:questionIds)")
    fun loadAllByIds(questionIds: IntArray): List<Question>

    @Query("SELECT * FROM question WHERE title LIKE :title LIMIT 1")
    fun findByTitle(title: String): Question

    @Insert
    fun insertAll(vararg questions: Question)

    @Insert
    fun insertQuestion(vararg question: Question)

    @Delete
    fun delete(question: Question)

    @Query("DELETE FROM question")
    fun nukeTable()
}