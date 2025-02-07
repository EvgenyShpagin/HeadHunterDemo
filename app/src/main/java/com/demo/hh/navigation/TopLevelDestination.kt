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
import kotlin.reflect.KClass

enum class TopLevelDestination(
    val icon: @Composable () -> Unit,
    @StringRes val iconTextId: Int,
    val route: KClass<*>,
) {
    MAIN(
        icon = { Icon(HhIcons.Search, null) },
        iconTextId = R.string.destination_main,
        route = MainDestination::class,
    ),
    FAVORITES(
        icon = { Icon(HhIcons.Favorites, null) },
        iconTextId = R.string.destination_main,
        route = Favorites::class,
    ),
    APPLIES(
        icon = { Icon(HhIcons.Applies, null) },
        iconTextId = R.string.destination_applies,
        route = Applies::class,
    ),
    MESSAGES(
        icon = { Icon(HhIcons.Messages, null) },
        iconTextId = R.string.destination_messages,
        route = Messages::class,
    ),
    PROFILE(
        icon = { Icon(HhIcons.Profile, null) },
        iconTextId = R.string.destination_profile,
        route = Profile::class,
    )
}