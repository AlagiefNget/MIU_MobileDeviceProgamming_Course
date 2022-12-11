package com.anget.cvappandroid.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import com.anget.cvappandroid.net.dtos.User
import com.anget.cvappandroid.net.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HomeViewModel(context: Context) : ViewModel() {
    private val jsonFileString = getJsonDataFromAsset(context, "home.json")
    private val gson = Gson()
    private val userType = object : TypeToken<User>() {}.type

    var user: User = gson.fromJson(jsonFileString, userType)
}