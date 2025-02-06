package com.demo.hh.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.hh.core.designsystem.icon.HhIcons
import com.demo.hh.core.designsystem.theme.Grey2
import com.demo.hh.core.designsystem.theme.Grey4
import com.demo.hh.core.designsystem.theme.HhTheme
import com.demo.hh.core.designsystem.theme.Red
import com.demo.hh.core.designsystem.theme.Text1
import com.demo.hh.core.designsystem.theme.White

@Composable
fun HhTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    isError: Boolean = false
) {
    val shape = RoundedCornerShape(8.dp)
    Column(modifier = modifier) {
        BasicTextField(
            modifier = Modifier
                .background(Grey2, shape)
                .let {
                    if (isError) it.border(1.dp, Red, shape) else it
                }
                .height(40.dp)
                .padding(horizontal = 8.dp),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            cursorBrush = SolidColor(White),
            textStyle = Text1.copy(color = White),
            enabled = enabled,
            decorationBox = { innerTextField ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    leadingIcon?.let {
                        CompositionLocalProvider(LocalContentColor provides White) {
                            leadingIcon()
                        }
                        Spacer(Modifier.width(8.dp))
                    }
                    Box(Modifier.weight(1f)) {
                        if (value.annotatedString.isEmpty()) {
                            ProvideTextStyle(Text1.copy(color = Grey4)) {
                                placeholder?.invoke()
                            }
                        }
                        innerTextField()
                    }
                    trailingIcon?.let {
                        CompositionLocalProvider(LocalContentColor provides White) {
                            trailingIcon()
                        }
                    }
                }
            }
        )

        supportingText?.let { supportingText ->
            Spacer(Modifier.height(8.dp))
            ProvideTextStyle(
                Text1.copy(color = if (isError) Red else Grey4)
            ) {
                supportingText()
            }
        }
    }
}


@Preview
@Composable
private fun HhTextFieldDefaultPreview() {
    HhTheme {
        HhTextField(
            value = TextFieldValue("Content"),
            onValueChange = {},
            leadingIcon = {
                Icon(HhIcons.Search, null)
            },
            trailingIcon = {
                Icon(HhIcons.Search, null)
            }
        )
    }
}

@Preview
@Composable
private fun HhTextFieldErrorPreview() {
    HhTheme {
        HhTextField(
            value = TextFieldValue(""),
            onValueChange = {},
            placeholder = {
                Text("Placeholder")
            },
            leadingIcon = {
                Icon(HhIcons.Search, null)
            },
            trailingIcon = {
                Icon(HhIcons.Search, null)
            },
            supportingText = {
                Text("Text")
            },
            isError = true
        )
    }
}