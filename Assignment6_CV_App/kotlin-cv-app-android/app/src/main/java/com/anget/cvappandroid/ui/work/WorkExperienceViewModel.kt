package com.anget.cvappandroid.ui.work

import android.content.Context
import androidx.lifecycle.ViewModel
import com.anget.cvappandroid.net.dtos.WorkExperience
import com.anget.cvappandroid.net.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class WorkExperienceViewModel(context: Context) : ViewModel() {
    private val jsonFileString = getJsonDataFromAsset(context, "work_experience.json")
    private val gson = Gson()
    private val careerHistoryType = object : TypeToken<List<WorkExperience>>() {}.type

    var careerHistoryList: List<WorkExperience> = gson.fromJson(jsonFileString, careerHistoryType)
}