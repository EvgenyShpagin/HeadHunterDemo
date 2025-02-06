package com.demo.hh.core.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

internal val ColorScheme = lightColorScheme(
    primary = Blue,
    onPrimary = White,
    primaryContainer = Blue,
    onPrimaryContainer = White,
    secondary = Green,
    onSecondary = Green,
    secondaryContainer = Green,
    onSecondaryContainer = White,
    background = Black,
    onBackground = White,
    surface = Black,
    onSurface = White,
    surfaceVariant = Grey1,
    onSurfaceVariant = White,
    surfaceContainer = Grey1,
    surfaceContainerHighest = Grey1,
    surfaceContainerHigh = Grey2,
    surfaceContainerLow = Grey1,
    surfaceContainerLowest = Grey1,
    outline = Grey2
)

@Composable
fun HeadHunterDemoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = ColorScheme,
        typography = Typography,
        content = content
    )
}