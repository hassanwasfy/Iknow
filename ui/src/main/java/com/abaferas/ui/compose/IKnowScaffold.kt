package com.abaferas.ui.compose

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.abaferas.ui.theme.color
import com.abaferas.ui.theme.dimens
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun IKnowScaffold(
    hasTopApp: Boolean = false,
    topAppBar: @Composable () -> Unit,
    hasBottomBar: Boolean = false,
    bottomBar: @Composable () -> Unit,
    isLoading: Boolean = true,
    isError: ErrorWrapper = ErrorWrapper(),
    reportError: @Composable () -> Unit,
    content: @Composable () -> Unit
) {
    val systemUiController = rememberSystemUiController()
    systemUiController.setSystemBarsColor(MaterialTheme.color.white, darkIcons = true)
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        AnimatedVisibility(visible = hasTopApp) {
            topAppBar()
        }
    }, bottomBar = {
        AnimatedVisibility(visible = hasBottomBar) {
            bottomBar()
        }
    }) { _ ->
        Column {
            AnimatedVisibility(visible = hasTopApp) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimens.dimens70)
                )
            }
            AnimatedVisibility(visible = isLoading) {
                ReportLoading()
            }
            AnimatedVisibility(visible = isError.flag) {
                reportError()
            }
            AnimatedVisibility(visible = !isLoading && !isError.flag) {
                content()
            }
            AnimatedVisibility(visible = hasBottomBar) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MaterialTheme.dimens.dimens70)
                )
            }
        }
    }
}