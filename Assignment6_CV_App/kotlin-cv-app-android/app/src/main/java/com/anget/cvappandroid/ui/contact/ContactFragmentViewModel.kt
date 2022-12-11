package com.anget.cvappandroid.ui.contact

import android.content.Context
import androidx.lifecycle.ViewModel
import com.anget.cvappandroid.net.dtos.Contact
import com.anget.cvappandroid.net.dtos.EducationTraining
import com.anget.cvappandroid.net.getJsonDataFromAsset
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ContactFragmentViewModel(context: Context) : ViewModel() {
    private val jsonFileString = getJsonDataFromAsset(context, "contact.json")
    private val gson = Gson()
    private val contactType = object : TypeToken<List<Contact>>() {}.type

    var contactList: List<Contact> = gson.fromJson(jsonFileString, contactType)
}