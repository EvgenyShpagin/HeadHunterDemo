package com.demo.hh.feature.main.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.demo.hh.core.designsystem.theme.HhTheme
import com.demo.hh.core.designsystem.theme.Title2
import com.demo.hh.core.model.Offer
import com.demo.hh.core.ui.component.VacancyCard
import com.demo.hh.core.ui.state.VacancyCardUiState
import com.demo.hh.core.ui.util.PreviewVacancyCardUiStateList
import com.demo.hh.main.R

@Composable
internal fun MainScreen(
    viewModel: MainViewModel,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    BackHandler {
        navigateBack()
    }

    val layoutDirection = LocalLayoutDirection.current

    val systemBarsPadding = WindowInsets.systemBars.asPaddingValues()
    val topPadding = systemBarsPadding.calculateTopPadding()
    val bottomPadding = systemBarsPadding.calculateBottomPadding()
    val startPadding = systemBarsPadding.calculateStartPadding(layoutDirection)
    val endPadding = systemBarsPadding.calculateEndPadding(layoutDirection)

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MainContent(
        offers = uiState.offers,
        onOffersClick = { TODO() },
        vacancies = uiState.relevantVacancies,
        isLoading = uiState.isLoading,
        onFavoriteClick = { viewModel.onEvent(MainUiEvent.SetFavorite(it)) },
        onApplyClick = { TODO() },
        moreVacancyCount = uiState.moreVacancyCount,
        onMoreVacancyClicked = { TODO() },
        modifier = modifier.padding(
            start = startPadding,
            top = topPadding,
            end = endPadding,
            bottom = bottomPadding
        )
    )

}

@Composable
private fun MainContent(
    offers: List<Offer>,
    onOffersClick: (Offer) -> Unit,
    vacancies: List<VacancyCardUiState>,
    onFavoriteClick: (VacancyCardUiState) -> Unit,
    onApplyClick: (VacancyCardUiState) -> Unit,
    moreVacancyCount: Int,
    onMoreVacancyClicked: () -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    lazyListState: LazyListState = rememberLazyListState()
) {

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        state = lazyListState
    ) {
        item {
            MainSearchBar(
                input = "",
                onInput = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            )
        }
        item {
            OfferList(
                offers = offers,
                onOfferClick = onOffersClick,
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier
            )
        }
        item {
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(R.string.title_vacancies_for_you),
                style = Title2,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
        items(vacancies) { vacancy ->
            VacancyCard(
                state = vacancy,
                onFavoriteClick = { onFavoriteClick(vacancy) },
                onApplyClick = { onApplyClick(vacancy) },
                Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            MoreVacancyButton(
                moreVacancyCount = moreVacancyCount,
                onClick = onMoreVacancyClicked,
                modifier = Modifier.fillMaxWidth().padding(start = 16.dp, bottom = 8.dp, end = 16.dp)
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainContentPreview() {
    HhTheme {
        Surface {
            MainContent(
                offers = PreviewOfferList,
                onOffersClick = {},
                vacancies = PreviewVacancyCardUiStateList.take(2),
                isLoading = false,
                onApplyClick = {},
                onFavoriteClick = {},
                moreVacancyCount = 9,
                onMoreVacancyClicked = {}
            )
        }
    }
}