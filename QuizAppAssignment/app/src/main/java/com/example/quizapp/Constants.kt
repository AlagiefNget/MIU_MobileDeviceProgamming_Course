package com.example.quizapp

object Constants {
    val USER_NAME: String = "user_name"
    val TOTAL_QUESTIONS: String = "total_questions"
    val SCORE: String = "score"

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val questionOne = Question(
            1,
            "If permissions are missing the application will get this at runtime?",
            arrayListOf("Security Exception", "Runtime Exception", "StackOverflow", "NPE"),
            0,
        )
        questionsList.add(questionOne)

        // 2
        val questionTwo = Question(
            2,
            "An open source standalone database?",
            arrayListOf("Oracle", "MongoDB",
            "SQLite", "MySQL"),
            2
        )
        questionsList.add(questionTwo)

        // 3
        val questionThree = Question(
            3,
            "Sharing of data in Android is done via?",
            arrayListOf("Redux", "Context API",
            "Database", "Service Content Provider"),
            3
        )
        questionsList.add(questionThree)

        // 4
        val questionFour = Question(
            4,
            "Main class through which your application can access location service on android?",
            arrayListOf("Google Maps", "LocationManager",
            "Location Store", "GPS"),
            1
        )
        questionsList.add(questionFour)

        // 5
        val questionFive = Question(
            5,
            "The primary constructor comes after the class name in the header part of the class?",
            arrayListOf("True", "False",
            "All of the above", "None of the above"),
            0
        )
        questionsList.add(questionFive)

        // 6
        val questionSix = Question(
            6,
            "Kotlin data types are object type?",
            arrayListOf("True", "False",
            "All of the above", "None of the above"),
            0
        )

        questionsList.add(questionSix)

        // 7
        val questionSeven = Question(
            7,
            "Kotlin Strings are mutable?",
            arrayListOf("True", "False",
            "All of the above", "None of the above"),
            1
        )
        questionsList.add(questionSeven)

        // 8
        val questionEight = Question(
            8,
            "What is not a way to handle Null Safety in Kotlin?",
            arrayListOf("Elvis Operator (?:)", "Safe Call (?.)",
            "Nullable check (!=)", "typeOf"),
            3
        )
        questionsList.add(questionEight)

        // 9
        val questionNine = Question(
            9,
            "If you want inheritance, in Kotlin you have to declare the parent class with the keyword ______?",
            arrayListOf("private", "open",
            "extends", "inherit"),
            1
        )
        questionsList.add(questionNine)

        // 10
        val questionTen = Question(
            10,
            "Which one is a type of intent?",
            arrayListOf("Implicit Intent", "Customized Intent",
            "Main Intent", "Json"),
            0
        )
        questionsList.add(questionTen)
        // 11
        val questionEleven = Question(
            11,
            "When developing for the Android OS, Java byte code is compiled into what?",
            arrayListOf("Java Byte Code", ".class code",
                "Dalvik Byte Code", "Dalvik Application Code"),
            2
        )
        questionsList.add(questionEleven)
        // 12
        val questionTwelve = Question(
            12,
            "Android sizes fonts of mobile using _______ unit of measurement?",
            arrayListOf("SP", "PX",
                "pixels", "fontWeight"),
            0
        )
        questionsList.add(questionTwelve)
        // 13
        val questionThirteen = Question(
            13,
            "Which one is not a nickname of Android?",
            arrayListOf("Froyo", "Cupcake",
                "Lollipop", "Muffin"),
            3
        )
        questionsList.add(questionThirteen)
        // 14
        val questionFourteen = Question(
            14,
            "What does apk stand for?",
            arrayListOf("Application Knowledge", "Application Package",
                "Application Programming Kit", "Application Kit"),
            1
        )
        questionsList.add(questionFourteen)

        // 15
        val questionFifteen = Question(
            15,
            "What was the first phone released that ran the Android OS?",
            arrayListOf("HTC Dream", "Samsung",
                "iPhone 6", "AT&T"),
            0
        )
        questionsList.add(questionFifteen)

        return questionsList
    }
}