package com.demo.hh.core.model

data class Vacancy(
    val id: String,
    val lookingNumber: Int,
    val title: String,
    val address: Address,
    val company: String,
    val experience: Experience,
    val publishedDate: Date,
    val isFavorite: Boolean,
    val salary: Salary,
    val schedules: Pair<EmploymentType, Schedule>,
    val appliedNumber: Int? = null,
    val description: String,
    val responsibilities: String,
    val questions: List<String>
)