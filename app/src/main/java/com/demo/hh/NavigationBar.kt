package com.demo.hh

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import com.demo.hh.core.designsystem.component.HhNavigationBar
import com.demo.hh.core.designsystem.component.HhNavigationBarItem
import com.demo.hh.core.designsystem.theme.TabText
import com.demo.hh.navigation.TopLevelDestination

@Composable
fun HhNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    HhNavigationBar(modifier = modifier) {
        TopLevelDestination.entries.forEachIndexed { i, info ->
            HhNavigationBarItem(
                selected = navBackStackEntry.isCurrentDestination(info.route),
                onClick = {
                    if (!navBackStackEntry.isCurrentDestination(info.route)) {
                        navController.navigate(
                            info.route,
                            navOptions { launchSingleTop = true }
                        )
                    }
                },
                icon = info.icon,
                label = {
                    Text(
                        stringResource(info.labelTextId),
                        style = TabText
                    )
                }
            )
        }
    }
}

private fun NavBackStackEntry?.isCurrentDestination(route: Any): Boolean {
    return this?.destination?.hasRoute(route::class) == true
}