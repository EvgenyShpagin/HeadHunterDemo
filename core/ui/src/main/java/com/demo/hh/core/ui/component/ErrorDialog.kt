package com.demo.hh.core.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.demo.hh.core.designsystem.theme.Black
import com.demo.hh.core.designsystem.theme.HhTheme
import com.demo.hh.core.designsystem.theme.Title3
import com.demo.hh.core.designsystem.theme.White
import com.demo.hh.core.ui.R

@Composable
fun NoInternetDialog(onDismissRequest: () -> Unit, modifier: Modifier = Modifier) {
    ErrorDialog(
        onDismissRequest = onDismissRequest,
        title = stringResource(R.string.title_no_internet_error),
        modifier = modifier
    )
}

@Composable
fun ServerErrorDialog(onDismissRequest: () -> Unit, modifier: Modifier = Modifier) {
    ErrorDialog(
        onDismissRequest = onDismissRequest,
        title = stringResource(R.string.title_server_error),
        modifier = modifier
    )
}

@Composable
fun OtherConnectionErrorDialog(onDismissRequest: () -> Unit, modifier: Modifier = Modifier) {
    ErrorDialog(
        onDismissRequest = onDismissRequest,
        title = stringResource(R.string.title_other_error),
        modifier = modifier
    )
}

@Composable
fun NotFoundErrorDialog(onDismissRequest: () -> Unit, modifier: Modifier = Modifier) {
    ErrorDialog(
        onDismissRequest = onDismissRequest,
        title = stringResource(R.string.title_not_found_error),
        modifier = modifier
    )
}


@Composable
fun ErrorDialog(
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    title: String?,
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = onDismissRequest,
        title = title?.let { { Text(it, style = Title3) } },
        containerColor = Black,
        textContentColor = White,
        titleContentColor = White,
        confirmButton = { Text(stringResource(R.string.button_ok)) }
    )
}

@Preview
@Composable
private fun ErrorDialogPreview() {
    HhTheme {
        ErrorDialog(
            onDismissRequest = {},
            title = "Title"
        )
    }
}