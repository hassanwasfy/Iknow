package com.abaferas.ui.compose

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.abaferas.ui.main.BottomNavBar
import com.abaferas.ui.main.currentDestination
import com.abaferas.ui.navigation.IKnowDestination
import com.abaferas.viewmodels.base.ErrorUiState


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BuildScaffold(
    topAppBar: @Composable () -> Unit = {},
    isLoading: Boolean = true,
    error: ErrorUiState?,
    onError: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(topBar = {
        topAppBar()
    }, bottomBar = {
        val visibility =
            (currentDestination()?.route ?: "") in listOf(
                IKnowDestination.Home.route,
                IKnowDestination.Search.route,
                IKnowDestination.Books.route,
                IKnowDestination.Saves.route,
            )
        BottomNavBar(visibility)
    }) { _ ->
        AnimatedVisibility(
            visible = isLoading
        ) {
            ReportLoading()
        }
        AnimatedVisibility(
            visible = error != null
        ) {
            ReportError(errorMsg = error!!.message) {
                onError()
            }
        }
        AnimatedVisibility(
            visible = !isLoading && error == null
        ) {
            content()
        }
    }
}