package com.demo.hh.feature.main.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.demo.hh.feature.main.ui.main.MainScreen
import kotlinx.serialization.Serializable
import org.koin.androidx.compose.koinViewModel

@Serializable
data object MainDestination

fun NavController.navigateToMain(navOptions: NavOptions? = null) {
    navigate(
        route = MainDestination,
        navOptions = navOptions
    )
}

fun NavGraphBuilder.mainScreen(navigateBack: () -> Unit) {
    composable<MainDestination> {
        MainScreen(
            viewModel = koinViewModel(),
            navigateBack = navigateBack
        )
    }
}