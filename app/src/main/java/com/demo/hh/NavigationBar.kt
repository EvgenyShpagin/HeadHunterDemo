package com.demo.hh

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.demo.hh.core.designsystem.component.HhNavigationBar
import com.demo.hh.core.designsystem.component.HhNavigationBarItem
import com.demo.hh.navigation.TopLevelDestination

@Composable
fun HhNavigationBar(
    selectedIndex: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HhNavigationBar(modifier = modifier) {
        TopLevelDestination.entries.forEachIndexed { i, info ->
            HhNavigationBarItem(
                selected = i == selectedIndex,
                onClick = onClick,
                icon = info.icon,
                label = { stringResource(info.labelTextId) }
            )
        }
    }
}