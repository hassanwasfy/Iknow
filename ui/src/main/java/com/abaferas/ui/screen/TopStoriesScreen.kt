package com.abaferas.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.abaferas.ui.compose.ReportError
import com.abaferas.ui.compose.ReportLoading
import com.abaferas.ui.compose.StateHandler
import com.abaferas.viewmodels.TopStoriesViewModel
import com.abaferas.viewmodels.TopStoryUiState


@Composable
fun TopStoriesScreen(
    topStoriesViewModel: TopStoriesViewModel = hiltViewModel()
) {
    val data = topStoriesViewModel.data.collectAsState().value
    TopStoriesScreenContent(data,
        topStoriesViewModel::retry)
}

@Composable
fun TopStoriesScreenContent(data: TopStoryUiState, retry: () -> Unit) {
    StateHandler(
        isLoading = data.isLoading,
        isError = data.isError.first,
        onLoading = { ReportLoading() },
        onFailure = {
            ReportError(data.isError.second){ retry() }
        }
    ) {
        Text(text = data.data[0].copyright)
    }
}