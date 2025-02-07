package com.demo.hh.core.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.hh.core.designsystem.icon.HhIcons
import com.demo.hh.core.designsystem.theme.Blue

@Composable
fun FavoriteIconButton(
    onClick: () -> Unit,
    isFavorite: Boolean,
    modifier: Modifier = Modifier
) {
    val (icon, contentDescription) = if (isFavorite) {
        HhIcons.FavoritesFilled to stringResource(R.string.cd_button_unset_favorite)
    } else {
        HhIcons.Favorites to stringResource(R.string.cd_button_set_favorite)
    }
    IconButton(
        onClick = onClick,
        modifier = modifier.size(24.dp)
    ) {
        Icon(icon, contentDescription, tint = Blue)
    }
}

@Preview(name = "Favorite")
@Composable
private fun FavoriteIconButtonPreview() {
    FavoriteIconButton(
        onClick = {},
        isFavorite = true
    )
}

@Preview(name = "Not Favorite")
@Composable
private fun NotFavoriteIconButtonPreview() {
    FavoriteIconButton(
        onClick = {},
        isFavorite = false
    )
}