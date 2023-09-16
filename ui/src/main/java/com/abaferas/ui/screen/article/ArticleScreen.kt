package com.abaferas.ui.screen.article

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.abaferas.ui.compose.BuildScaffold
import com.abaferas.ui.navigation.NavigationHandler
import com.abaferas.ui.screen.onboarding.StatusBarColors
import com.abaferas.viewmodels.screen.home.HomeInteractionListener
import com.abaferas.viewmodels.screen.home.HomeUiEffect
import com.abaferas.viewmodels.screen.home.HomeUiState
import com.abaferas.viewmodels.screen.home.HomeViewModel

@Composable
fun ArticleScreen(homeViewModel: HomeViewModel = hiltViewModel()) {
    StatusBarColors()
    val state = homeViewModel.state.collectAsState().value
    ArticleScreenContent(state, homeViewModel)
    NavigationHandler(effects = homeViewModel.effect) { effect, nav ->
        when (effect) {
            is HomeUiEffect.NavigateToArticle -> {
            }

            HomeUiEffect.NavigateToBooks -> {
            }

            HomeUiEffect.NavigateToSaves -> {
            }

            HomeUiEffect.NavigateToSearch -> {
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ArticleScreenContent(state: HomeUiState, listener: HomeInteractionListener) {
    BuildScaffold(

        isLoading = state.isLoading,
        error = state.error,
    ) {

    }
}
