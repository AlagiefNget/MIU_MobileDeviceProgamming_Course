package com.anget.cvappandroid.net

import android.content.Context
import java.io.IOException

fun getJsonDataFromAsset(context: Context, fileName: String): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

fun stringHyphen(list: List<String>?): String? {
    var str = ""
    try {
        if (!list.isNullOrEmpty()) {
            for (item in list) {
                str += if (list.last() == item) {
                    item
                } else {
                    "$item - "
                }
            }
        }
    } catch (e: IOException) {
        return null
    }

    return str
}

fun stringBullet(list: List<String>?): String? {
    var str = ""
    try {
        if (!list.isNullOrEmpty()) {
            for (item in list) {
                str += if (list.last() == item) {
                    "\u2022 $item"
                } else {
                    "\u2022 $item\n"
                }
            }
        }
    } catch (e: IOException) {
        return null
    }

    return str
}