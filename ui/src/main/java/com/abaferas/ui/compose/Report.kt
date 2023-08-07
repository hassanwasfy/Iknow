package com.abaferas.ui.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.abaferas.ui.R
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun ReportLoading() {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.animation))
    LottieAnimation(
        modifier = Modifier.fillMaxSize(), composition = composition, iterations = 1
    )
}

@Composable
fun ReportError(errorMsg: String,handleError: () -> Unit) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.error))

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LottieAnimation(
            modifier = Modifier.align(Alignment.Center)
                .fillMaxSize(),
            composition = composition, iterations = 50
        )
        Text(
            text = errorMsg,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(vertical = 80.dp)
        )
        Button(onClick = handleError,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(text = "Try Again")
        }
    }
}