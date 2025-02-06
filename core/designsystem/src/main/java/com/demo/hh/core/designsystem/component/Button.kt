package com.demo.hh.core.designsystem.component

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.hh.core.designsystem.icon.HhIcons
import com.demo.hh.core.designsystem.theme.Blue
import com.demo.hh.core.designsystem.theme.DarkBlue
import com.demo.hh.core.designsystem.theme.DarkGreen
import com.demo.hh.core.designsystem.theme.Green
import com.demo.hh.core.designsystem.theme.Grey2
import com.demo.hh.core.designsystem.theme.Grey4
import com.demo.hh.core.designsystem.theme.HhTheme
import com.demo.hh.core.designsystem.theme.White

@Composable
fun HhPrimaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue,
            contentColor = White,
            disabledContainerColor = DarkBlue,
            disabledContentColor = Grey4
        ),
        content = content
    )
}

@Preview
@Composable
private fun HhPrimaryButtonPreview() {
    HhTheme {
        HhPrimaryButton(onClick = {}) {
            Text("Primary button")
        }
    }
}

@Composable
fun HhSecondarySmallButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    HhSecondaryButton(
        onClick = onClick,
        modifier = modifier.height(40.dp),
        enabled = enabled,
        shape = CircleShape,
        content = content
    )
}

@Preview
@Composable
private fun HhSecondarySmallButtonPreview() {
    HhTheme {
        HhSecondarySmallButton(onClick = {}) {
            Text("Secondary small button")
        }
    }
}

@Composable
fun HhSecondaryLargeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    HhSecondaryButton(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        content = content
    )
}

@Preview
@Composable
private fun HhSecondaryLargeButtonPreview() {
    HhTheme {
        HhSecondaryLargeButton(onClick = {}) {
            Text("Secondary large button")
        }
    }
}

@Composable
private fun HhSecondaryButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean,
    shape: Shape,
    content: @Composable RowScope.() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Green,
            contentColor = White,
            disabledContainerColor = DarkGreen,
            disabledContentColor = Grey4
        ),
        content = content
    )
}

@Composable
fun HhExtendedFloatingActionButton(
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    ExtendedFloatingActionButton(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        shape = CircleShape,
        containerColor = Grey2,
        contentColor = White,
        icon = icon,
        text = text
    )
}

@Preview
@Composable
private fun HhExtendedFloatingActionButtonPreview() {
    HhTheme {
        HhExtendedFloatingActionButton(
            onClick = {},
            icon = { Icon(HhIcons.Map, null) },
            text = { Text("Map") }
        )
    }
}

@Composable
fun HhFilledIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier.size(40.dp),
        content = content,
        enabled = enabled,
        shape = RoundedCornerShape(10.dp),
        colors = IconButtonDefaults.filledIconButtonColors(
            containerColor = Grey2,
            contentColor = White,
            disabledContainerColor = Grey2
        )
    )
}

@Preview
@Composable
private fun HhFilledIconButtonPreview() {
    HhTheme {
        HhFilledIconButton(
            onClick = {},
            content = {
                Icon(HhIcons.Settings, null)
            }
        )
    }
}

@Composable
fun HhPrimaryTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = Blue,
            disabledContentColor = DarkBlue
        ),
        content = content
    )
}

@Preview
@Composable
private fun HhPrimaryTextButtonPreview() {
    HhTheme {
        HhPrimaryTextButton(
            onClick = {},
            content = { Text("Text button") }
        )
    }
}

@Composable
fun HhSecondaryTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.height(48.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            contentColor = Green,
            disabledContentColor = DarkGreen
        ),
        content = content
    )
}

@Preview
@Composable
private fun HhSecondaryTextButtonPreview() {
    HhTheme {
        HhSecondaryTextButton(
            onClick = {},
            content = { Text("Text button") }
        )
    }
}