package com.demo.hh.feature.main.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.hh.core.designsystem.component.HhFilledIconButton
import com.demo.hh.core.designsystem.component.HhTextField
import com.demo.hh.core.designsystem.icon.HhIcons
import com.demo.hh.core.designsystem.theme.Blue
import com.demo.hh.core.designsystem.theme.DarkBlue
import com.demo.hh.core.designsystem.theme.DarkGreen
import com.demo.hh.core.designsystem.theme.Green
import com.demo.hh.core.designsystem.theme.Grey1
import com.demo.hh.core.designsystem.theme.Text1
import com.demo.hh.core.designsystem.theme.Title4
import com.demo.hh.core.designsystem.theme.White
import com.demo.hh.core.model.Offer

private val TitleStyle = Title4.copy(color = White)
private val ActionStyle = Text1.copy(color = Green)

@Composable
internal fun OfferCard(
    offer: Offer,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier.size(132.dp, 120.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Grey1)
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
        ) {
            if (offer.id.isNotEmpty()) {
                OfferIcon(offer.id)
                Spacer(Modifier.height(16.dp))
            }
            Text(
                offer.title,
                style = TitleStyle,
                maxLines = if (offer.action != null) 2 else 3,
                overflow = TextOverflow.Ellipsis
            )
            offer.action?.let { actionText ->
                Text(actionText, style = ActionStyle)
            }
        }
    }
}

@Composable
private fun OfferIcon(
    offerId: String,
    modifier: Modifier = Modifier
) {
    val (colors, icon) = when (offerId) {
        "near_vacancies" -> (DarkBlue to Blue) to HhIcons.Map
        "level_up_resume" -> (DarkGreen to Green) to HhIcons.Star
        "temporary_job" -> (DarkGreen to Green) to HhIcons.Vacancies
        else -> return
    }
    val (containerColor, contentColor) = colors
    Box(
        modifier = modifier
            .size(32.dp)
            .background(containerColor, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview
@Composable
private fun OfferCardPreview() {
    OfferCard(
        Offer(
            id = "level_up_resume",
            title = "Поднять резюме в поиске",
            link = "",
            action = "Поднять"
        ),
        onClick = {}
    )
}

@Composable
internal fun OfferList(
    offers: List<Offer>,
    onOfferClick: (Offer) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(offers) { offer ->
            OfferCard(
                offer = offer,
                onClick = { onOfferClick(offer) }
            )
        }
    }
}

@Preview
@Composable
private fun OfferListPreview() {
    OfferList(
        listOf(
            Offer(
                id = "near_vacancies",
                title = "Вакансии рядом с вами",
                link = ""
            ),
            Offer(
                id = "level_up_resume",
                title = "Поднять резюме в поиске",
                link = "",
                action = "Поднять"
            ),
            Offer(
                id = "temporary_job",
                title = "Временная работа или подработка",
                link = ""
            ),
            Offer(
                id = "",
                title = "Полезные статьи и советы",
                link = "",
            )
        ),
        onOfferClick = {}
    )
}

@Composable
internal fun MainSearchBar(
    input: String,
    onInput: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        HhTextField(
            value = input,
            onValueChange = onInput,
            modifier = Modifier.weight(1f)
        )
        HhFilledIconButton(onClick = {}) {
            Icon(HhIcons.Settings, contentDescription = null)
        }
    }
}

@Preview
@Composable
private fun MainSearchBarPreview() {
    MainSearchBar("", {})
}