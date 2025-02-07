package com.demo.hh.feature.main.ui.main

import com.demo.hh.core.mvi.UiEvent
import com.demo.hh.core.ui.state.VacancyCardUiState

sealed interface MainUiEvent : UiEvent {
    data class SetFavorite(val vacancy: VacancyCardUiState) : MainUiEvent
}