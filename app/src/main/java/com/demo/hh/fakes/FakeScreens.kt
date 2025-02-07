package com.demo.hh.fakes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.serialization.Serializable


@Serializable
data object Favorites

@Serializable
data object Applies

@Serializable
data object Messages

@Serializable
data object Profile

@Composable
fun FavoritesScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text("Favorites Screen", Modifier.align(Alignment.Center))
    }
}

@Composable
fun AppliesScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text("Applies Screen", Modifier.align(Alignment.Center))
    }
}

@Composable
fun MessagesScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text("Messages Screen", Modifier.align(Alignment.Center))
    }
}

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize()) {
        Text("Favorites Screen", Modifier.align(Alignment.Center))
    }
}
