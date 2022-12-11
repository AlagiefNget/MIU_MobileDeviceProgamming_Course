package com.anget.cvappandroid.ui.education

import android.content.Context
import androidx.lifecycle.ViewModel
import com.anget.cvappandroid.net.dtos.EducationTraining
import com.anget.cvappandroid.net.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class EducationTrainingViewModel(context: Context) : ViewModel() {
    private val jsonFileString = getJsonDataFromAsset(context, "education_training.json")
    private val gson = Gson()
    private val educationType = object : TypeToken<List<EducationTraining>>() {}.type

    var educationList: List<EducationTraining> = gson.fromJson(jsonFileString, educationType)
}