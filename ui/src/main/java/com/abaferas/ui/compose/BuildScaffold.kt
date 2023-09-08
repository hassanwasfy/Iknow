package com.abaferas.ui.compose

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abaferas.ui.R
import com.abaferas.ui.main.BottomNavBar
import com.abaferas.ui.main.currentDestination
import com.abaferas.ui.navigation.IKnowDestination
import com.abaferas.viewmodels.base.ErrorUiState


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildScaffold(
    title: String,
    isLoading: Boolean = true,
    error: ErrorUiState?,
    onError: () -> Unit = {},
    content: @Composable () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = title) }, actions = {
            Image(
                painter = painterResource(id = R.drawable.topapp_logo),
                contentDescription = "",
                modifier = Modifier.padding(end = 16.dp)
            )
        })
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