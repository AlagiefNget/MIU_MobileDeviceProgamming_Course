package com.anget.cvappandroid.net.dtos

data class WorkExperience(
    val role: String?,
    val company: String?,
    val address: Address,
    val date: Date?,
    val description: String?,
    val description_points: List<String>?,
    val technical_skills: List<String>?,
    val key_achievements: List<String>?
)

data class Date(
    val start: String?,
    val end: String?
)