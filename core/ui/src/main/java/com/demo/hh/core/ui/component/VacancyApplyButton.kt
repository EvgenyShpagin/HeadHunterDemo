package com.demo.hh.core.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.demo.hh.core.designsystem.component.HhSecondaryLargeButton
import com.demo.hh.core.designsystem.component.HhSecondarySmallButton
import com.demo.hh.core.designsystem.theme.HhTheme
import com.demo.hh.core.ui.R

@Composable
fun VacancyApplyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HhSecondarySmallButton(
        onClick = onClick,
        modifier = modifier,
        content = {
            Text(stringResource(R.string.button_apply_for_vacancy))
        }
    )
}

@Preview
@Composable
private fun VacancyApplyButtonPreview() {
    HhTheme {
        VacancyApplyButton({})
    }
}

@Composable
fun LargeVacancyApplyButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HhSecondaryLargeButton(
        onClick = onClick,
        modifier = modifier,
        content = {
            Text(stringResource(R.string.button_apply_for_vacancy))
        }
    )
}

@Preview
@Composable
private fun LargeVacancyApplyButtonPreview() {
    HhTheme {
        LargeVacancyApplyButton({})
    }
}