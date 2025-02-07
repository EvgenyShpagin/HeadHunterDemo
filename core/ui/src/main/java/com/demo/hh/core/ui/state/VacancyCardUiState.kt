package com.demo.hh.core.ui.state

data class VacancyCardUiState(
    val title: String,
    val lookingNumber: Int,
    val salary: String?,
    val town: String,
    val company: String,
    val experience: String,
    val publishDate: String,
    val isFavorite: Boolean
)
