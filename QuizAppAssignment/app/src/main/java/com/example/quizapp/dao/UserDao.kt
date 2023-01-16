package com.example.quizapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.quizapp.entities.User


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE uid == :userId")
    fun loadById(userId: Int): User

    @Query("SELECT * FROM user WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Insert
    fun insertUser(vararg user: User)

    @Delete
    fun delete(user: User)

    @Query("UPDATE user SET score = :score, total_questions = :totalQuestions WHERE uid =:id")
    fun update(score: String?, totalQuestions: String?, id: Int)

    @Query("DELETE FROM user")
    fun nukeTable()
}