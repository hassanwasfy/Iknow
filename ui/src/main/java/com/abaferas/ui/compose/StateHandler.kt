package com.abaferas.ui.compose

import androidx.compose.runtime.Composable

@Composable
fun StateHandler(
    isLoading: Boolean,
    isError: Boolean,
    onLoading: @Composable () -> Unit,
    onFailure: @Composable () -> Unit,
    onSuccess: @Composable () -> Unit,
) {
    when {
        isLoading -> {
            onLoading()
        }
        !isError -> {
            onSuccess()
        }
        else -> {
            onFailure()
        }
    }
}