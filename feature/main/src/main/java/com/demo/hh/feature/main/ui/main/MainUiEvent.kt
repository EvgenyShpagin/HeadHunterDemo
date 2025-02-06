package com.demo.hh.feature.main.ui.main

import com.demo.hh.core.mvi.UiEvent

sealed interface MainUiEvent : UiEvent {
    data class SetFavorite(val vacancyId: String) : MainUiEvent
}