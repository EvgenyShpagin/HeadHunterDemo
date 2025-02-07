package com.demo.hh.core.ui.state

import com.demo.hh.core.model.Date
import com.demo.hh.core.model.Experience
import com.demo.hh.core.model.Salary

data class VacancyCardUiState(
    val title: String,
    val lookingNumber: Int,
    val salary: Salary,
    val town: String,
    val company: String,
    val experience: Experience,
    val publishDate: Date,
    val isFavorite: Boolean
)
