package com.demo.hh.feature.main.ui.main

import com.demo.hh.core.model.Offer
import com.demo.hh.core.model.Vacancy
import com.demo.hh.core.mvi.UiState

data class MainUiState(
    val isLoading: Boolean = true,
    val offers: List<Offer> = emptyList(),
    val relevantVacancies: List<Vacancy> = emptyList(),
    val moreVacancyCount: Int = 0
) : UiState