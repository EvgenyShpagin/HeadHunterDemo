package com.demo.hh.core.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.hh.core.designsystem.icon.HhIcons
import com.demo.hh.core.designsystem.theme.Green
import com.demo.hh.core.designsystem.theme.Grey1
import com.demo.hh.core.designsystem.theme.Grey3
import com.demo.hh.core.designsystem.theme.HhTheme
import com.demo.hh.core.designsystem.theme.Text1
import com.demo.hh.core.designsystem.theme.Title2
import com.demo.hh.core.designsystem.theme.Title3
import com.demo.hh.core.designsystem.theme.White
import com.demo.hh.core.ui.R
import com.demo.hh.core.ui.state.VacancyCardUiState
import com.demo.hh.core.ui.util.PreviewVacancyCardUiStateList


private val LookingNumberTextStyle = Text1.copy(color = Green)
private val PublishDateTextStyle = Text1.copy(color = Grey3)

@Composable
fun VacancyCard(
    state: VacancyCardUiState,
    onFavoriteClick: () -> Unit,
    onApplyClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = Grey1,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Column(
                    modifier = Modifier.widthIn(max = 220.dp),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    if (state.lookingNumber != 0) {
                        LookingNumber(state.lookingNumber)
                    }
                    Text(state.title, style = Title3)
                    if (state.salary != null) {
                        Text(state.salary, style = Title2)
                    }
                    Column {
                        Text(state.town, style = Text1)
                        Spacer(Modifier.size(4.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(state.company, style = Text1)
                            Spacer(Modifier.size(8.dp))
                            Icon(HhIcons.CheckCircle, null, tint = Grey3)
                        }
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(HhIcons.Bag, null, tint = White)
                        Spacer(Modifier.size(8.dp))
                        Text(
                            state.experience,
                            style = Text1
                        )
                    }
                    Text(
                        state.publishDate,
                        style = PublishDateTextStyle
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    FavoriteIconButton(
                        onClick = onFavoriteClick,
                        isFavorite = state.isFavorite,
                        modifier = Modifier.align(Alignment.TopEnd)
                    )
                }
            }
            VacancyApplyButton(
                onClick = onApplyClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}


@Composable
private fun LookingNumber(
    number: Int,
    modifier: Modifier = Modifier
) {
    Text(
        pluralStringResource(R.plurals.looking_number, number, number),
        style = LookingNumberTextStyle,
        modifier = modifier
    )
}

@Preview
@Composable
private fun VacancyCardPreview() {
    HhTheme {
        VacancyCard(
            PreviewVacancyCardUiStateList.first(),
            onApplyClick = {},
            onFavoriteClick = {}
        )
    }
}