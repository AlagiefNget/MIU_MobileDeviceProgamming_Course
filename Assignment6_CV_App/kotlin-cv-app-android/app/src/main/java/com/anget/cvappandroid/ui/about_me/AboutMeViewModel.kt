package com.anget.cvappandroid.ui.about_me

import android.content.Context
import androidx.lifecycle.ViewModel
import com.anget.cvappandroid.net.dtos.Language
import com.anget.cvappandroid.net.dtos.TechnicalSkills
import com.anget.cvappandroid.net.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AboutMeViewModel(context: Context) : ViewModel() {
    private val jsonTechnicalFileString = getJsonDataFromAsset(context, "about_me.json")
    private val jsonLanguagesFileString = getJsonDataFromAsset(context, "languages.json")
    private val gson = Gson()

    private val technicalSkillsType = object : TypeToken<List<TechnicalSkills>>() {}.type
    private val languagesType = object : TypeToken<List<Language>>() {}.type

    var technicalSkillsList: List<TechnicalSkills> = gson.fromJson(jsonTechnicalFileString, technicalSkillsType)
    var languageList: List<Language> = gson.fromJson(jsonLanguagesFileString, languagesType)
}