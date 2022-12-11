package com.anget.cvappandroid.net.dtos

data class Language(
    val language: String?,
    val item: String?,
    val level: Int?
)

enum class Item {
    Native,
    Fluent,
    Elementary,
    Basic,
    None
}