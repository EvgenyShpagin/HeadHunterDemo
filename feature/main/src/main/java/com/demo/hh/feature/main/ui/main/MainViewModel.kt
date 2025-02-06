package com.demo.hh.feature.main.ui.main

import androidx.lifecycle.viewModelScope
import com.demo.hh.core.domain.usecase.GetRelevantVacanciesUseCase
import com.demo.hh.core.domain.usecase.GetRelevantVacancyCountUseCase
import com.demo.hh.core.domain.usecase.SetVacancyFavoriteUseCase
import com.demo.hh.core.model.Vacancy
import com.demo.hh.core.mvi.ImmutableStateViewModel
import com.demo.hh.feature.main.domain.GetOffersUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

private const val INIT_VACANCY_COUNT = 3

class MainViewModel(
    getOffersUseCase: GetOffersUseCase,
    getRelevantVacanciesUseCase: GetRelevantVacanciesUseCase,
    getRelevantVacancyCountUseCase: GetRelevantVacancyCountUseCase,
    private val setVacancyFavoriteUseCase: SetVacancyFavoriteUseCase
) : ImmutableStateViewModel<MainUiState, MainUiEvent, MainUiEffect>() {

    override val uiState = combine(
        getOffersUseCase(),
        getRelevantVacanciesUseCase(INIT_VACANCY_COUNT),
        getRelevantVacancyCountUseCase()
    ) { offers, vacancies, vacancyCount ->
        MainUiState(
            isLoading = false,
            offers = offers,
            relevantVacancies = vacancies,
            moreVacancyCount = vacancyCount - INIT_VACANCY_COUNT
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainUiState()
    )

    override fun onEvent(event: MainUiEvent) {
        when (event) {
            is MainUiEvent.SetFavorite -> setFavorite(event.vacancyId)
        }
    }

    private fun setFavorite(vacancyId: String) {
        viewModelScope.launch {
            setVacancyFavoriteUseCase(
                vacancyId,
                favorite = !isFavorite(vacancyId)
            )
        }
    }

    private fun isFavorite(id: String): Boolean {
        return uiState.value.relevantVacancies.isFavorite(id)
    }

    private fun List<Vacancy>.isFavorite(id: String): Boolean {
        return find { it.id == id && it.isFavorite }!!.isFavorite
    }
}