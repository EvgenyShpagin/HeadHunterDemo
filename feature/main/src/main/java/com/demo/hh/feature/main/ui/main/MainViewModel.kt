package com.demo.hh.feature.main.ui.main

import androidx.lifecycle.viewModelScope
import com.demo.hh.core.domain.usecase.GetRelevantVacanciesUseCase
import com.demo.hh.core.domain.usecase.GetRelevantVacancyCountUseCase
import com.demo.hh.core.domain.usecase.SetVacancyFavoriteUseCase
import com.demo.hh.core.mvi.ImmutableStateViewModel
import com.demo.hh.core.ui.state.VacancyCardUiState
import com.demo.hh.core.ui.util.VacancyCardUiStateMapper
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
    private val vacancyCardMapper: VacancyCardUiStateMapper,
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
            relevantVacancies = vacancies.map { vacancyCardMapper.map(it) },
            moreVacancyCount = vacancyCount - INIT_VACANCY_COUNT
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = MainUiState()
    )

    override fun onEvent(event: MainUiEvent) {
        when (event) {
            is MainUiEvent.SetFavorite -> setFavorite(event.vacancy)
        }
    }

    private fun setFavorite(vacancy: VacancyCardUiState) {
        viewModelScope.launch {
            setVacancyFavoriteUseCase(
                vacancyId = vacancy.id,
                favorite = !vacancy.isFavorite
            )
        }
    }
}