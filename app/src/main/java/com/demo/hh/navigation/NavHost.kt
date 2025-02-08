package com.demo.hh.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.demo.hh.fakes.Applies
import com.demo.hh.fakes.AppliesScreen
import com.demo.hh.fakes.Favorites
import com.demo.hh.fakes.FavoritesScreen
import com.demo.hh.fakes.Messages
import com.demo.hh.fakes.MessagesScreen
import com.demo.hh.fakes.Profile
import com.demo.hh.fakes.ProfileScreen
import com.demo.hh.feature.main.ui.navigation.mainScreen

@Composable
fun HhNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = TopLevelDestination.MAIN.route,
        modifier = modifier
    ) {
        mainScreen(navController::popBackStack)

        composable<Favorites> {
            FavoritesScreen()
        }
        composable<Applies> {
            AppliesScreen()
        }
        composable<Messages> {
            MessagesScreen()
        }
        composable<Profile> {
            ProfileScreen()
        }
    }
}