package com.demo.hh.feature.main.ui.main

import com.demo.hh.core.common.network.FetchError
import com.demo.hh.core.mvi.UiEffect

sealed interface MainUiEffect : UiEffect {
    data class ShowError(val error: FetchError)
}