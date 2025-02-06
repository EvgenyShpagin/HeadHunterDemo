package com.demo.hh.core.designsystem.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.hh.core.designsystem.icon.HhIcons
import com.demo.hh.core.designsystem.theme.Black
import com.demo.hh.core.designsystem.theme.Blue
import com.demo.hh.core.designsystem.theme.Grey4
import com.demo.hh.core.designsystem.theme.HhTheme
import com.demo.hh.core.designsystem.theme.Red
import com.demo.hh.core.designsystem.theme.White

@Composable
fun RowScope.HhNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    alwaysShowLabel: Boolean = true,
    icon: @Composable () -> Unit,
    selectedIcon: @Composable () -> Unit = icon,
    label: @Composable (() -> Unit)? = null,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = Blue,
            unselectedIconColor = Grey4,
            selectedTextColor = Blue,
            unselectedTextColor = Grey4,
            indicatorColor = Color.Transparent,
        )
    )
}

@Preview(widthDp = 100)
@Composable
private fun HhNavigationBarItemPreview() {
    HhTheme {
        Row {
            HhNavigationBarItem(
                selected = true,
                onClick = {},
                icon = {
                    Icon(HhIcons.Settings, null)
                },
                label = {
                    Text("Settings")
                }
            )
        }
    }
}

@Composable
fun HhNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        containerColor = Black,
        tonalElevation = 0.dp,
        content = content
    )
}

@Preview
@Composable
private fun HhNavigationBarPreview() {
    HhTheme {
        HhNavigationBar(
            content = {
                HhNavigationBarItem(
                    selected = true,
                    onClick = {},
                    label = { Text("Search") },
                    icon = { Icon(HhIcons.Search, null) }
                )
                HhNavigationBarItem(
                    selected = false,
                    onClick = {},
                    label = { Text("Search") },
                    icon = { Icon(HhIcons.Favorites, null) }
                )
                HhNavigationBarItem(
                    selected = false,
                    onClick = {},
                    label = { Text("Applies") },
                    icon = { Icon(HhIcons.Applies, null) }
                )
                HhNavigationBarItem(
                    selected = false,
                    onClick = {},
                    label = { Text("Messages") },
                    icon = { Icon(HhIcons.Messages, null) }
                )
                HhNavigationBarItem(
                    selected = false,
                    onClick = {},
                    label = { Text("Profile") },
                    icon = { Icon(HhIcons.Profile, null) }
                )
            }
        )
    }
}

@Composable
fun HhBadge(
    modifier: Modifier = Modifier,
    content: @Composable (RowScope.() -> Unit)?
) {
    Badge(
        modifier = modifier,
        content = content,
        containerColor = Red,
        contentColor = White
    )
}

@Preview
@Composable
private fun HhBadgePreview() {
    HhTheme {
        HhBadge { Text("3") }
    }
}