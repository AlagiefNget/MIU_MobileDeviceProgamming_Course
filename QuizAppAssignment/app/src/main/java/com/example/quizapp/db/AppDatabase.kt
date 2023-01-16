package com.example.quizapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.quizapp.converters.Converters
import com.example.quizapp.dao.QuestionDao
import com.example.quizapp.entities.User
import com.example.quizapp.dao.UserDao
import com.example.quizapp.entities.Question

@Database(entities = [User::class, Question::class], version = 4)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun questionsDao(): QuestionDao

    companion object {

//        var INSTANCE: AppDatabase? = null
        @Volatile private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        fun getUserDaoDatabase(context: Context): AppDatabase? {
            if(INSTANCE == null) {
//                synchronized(AppDatabase::class) {
                synchronized(LOCK) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "user_db"
                    )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                }
            }
            return INSTANCE
        }

        fun getQuestionsDaoDatabase(context: Context): AppDatabase? {
            if(INSTANCE == null) {
//                synchronized(AppDatabase::class) {
                synchronized(LOCK) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "questions_db"
                    )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                }
            }
            return INSTANCE
        }

        fun destroy() {
            INSTANCE = null
        }
    }

}