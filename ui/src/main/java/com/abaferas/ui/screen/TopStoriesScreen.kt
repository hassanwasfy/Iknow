package com.abaferas.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.abaferas.viewmodels.TopStoriesViewModel
import com.abaferas.viewmodels.TopStoryUiState


@Composable
fun TopStoriesScreen(
    topStoriesViewModel: TopStoriesViewModel = hiltViewModel()
){
    val data = topStoriesViewModel.data.collectAsState().value
    TopStoriesScreenContent(data)
}

@Composable
fun TopStoriesScreenContent(data: TopStoryUiState) {
    when (data.isLoading){
        true -> {
            Text(text = "Currently Loading")
        }
        false -> {
            if (!data.isError.first){
                Text(text = data.data[0].copyright)
            }else{
                Text(text = data.isError.second)
            }
        }
    }
}
