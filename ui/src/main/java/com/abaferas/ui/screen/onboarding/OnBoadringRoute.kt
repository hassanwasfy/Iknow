package com.abaferas.ui.screen.onboarding

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abaferas.ui.navigation.IKnowDestination

fun NavGraphBuilder.onBoardingRoute() {
    composable(route = IKnowDestination.OnBoarding.route) {
        OnBoardingScreen()
    }
}