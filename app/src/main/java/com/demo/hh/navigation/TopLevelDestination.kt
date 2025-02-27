package com.demo.hh.navigation

import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.demo.hh.R
import com.demo.hh.core.designsystem.icon.HhIcons
import com.demo.hh.fakes.Applies
import com.demo.hh.fakes.Favorites
import com.demo.hh.fakes.Messages
import com.demo.hh.fakes.Profile
import com.demo.hh.feature.main.ui.navigation.MainDestination

enum class TopLevelDestination(
    val icon: @Composable (() -> Unit),
    @StringRes val labelTextId: Int,
    val route: Any,
) {
    MAIN(
        icon = { Icon(HhIcons.Search, null) },
        labelTextId = R.string.destination_main,
        route = MainDestination,
    ),
    FAVORITES(
        icon = { Icon(HhIcons.Favorites, null) },
        labelTextId = R.string.destination_main,
        route = Favorites,
    ),
    APPLIES(
        icon = { Icon(HhIcons.Applies, null) },
        labelTextId = R.string.destination_applies,
        route = Applies,
    ),
    MESSAGES(
        icon = { Icon(HhIcons.Messages, null) },
        labelTextId = R.string.destination_messages,
        route = Messages,
    ),
    PROFILE(
        icon = { Icon(HhIcons.Profile, null) },
        labelTextId = R.string.destination_profile,
        route = Profile,
    )
}