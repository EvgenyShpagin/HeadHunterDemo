package com.demo.hh.core.ui.util

import androidx.compose.runtime.Composable
import com.demo.hh.core.model.Date
import com.demo.hh.core.model.Experience
import com.demo.hh.core.model.Salary
import com.demo.hh.core.model.Vacancy
import com.demo.hh.core.ui.state.VacancyCardUiState

@Composable
fun Vacancy.toVacancyCardUiState(
    experienceFormatter: @Composable (experience: Experience) -> String = { it.asString() },
    dateFormatter: @Composable (date: Date) -> String = { it.asString() },
    salaryFormatter: @Composable (salary: Salary) -> String = { it.asString() },
): VacancyCardUiState {
    return VacancyCardUiState(
        title = title,
        lookingNumber = lookingNumber,
        salary = salaryFormatter(salary),
        town = address.town,
        company = company,
        experience = experienceFormatter(experience),
        publishDate = dateFormatter(publishedDate),
        isFavorite = isFavorite,
    )
}