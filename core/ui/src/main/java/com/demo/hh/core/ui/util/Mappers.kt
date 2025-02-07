package com.demo.hh.core.ui.util

import android.content.Context
import com.demo.hh.core.model.Vacancy
import com.demo.hh.core.ui.state.VacancyCardUiState


interface VacancyCardUiStateMapper {
    fun map(vacancy: Vacancy): VacancyCardUiState
}

class VacancyCardUiStateMapperImpl(private val applicationContext: Context) : VacancyCardUiStateMapper {
    override fun map(vacancy: Vacancy): VacancyCardUiState {
        return VacancyCardUiState(
            id = vacancy.id,
            title = vacancy.title,
            lookingNumber = vacancy.lookingNumber,
            salary = vacancy.salary.toString(applicationContext),
            town = vacancy.address.town,
            company = vacancy.company,
            experience = vacancy.experience.toString(applicationContext),
            publishDate = vacancy.publishedDate.toString(applicationContext),
            isFavorite = vacancy.isFavorite,
        )
    }
}