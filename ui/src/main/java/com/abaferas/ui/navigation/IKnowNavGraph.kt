package com.abaferas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.abaferas.ui.main.LocalNavController
import com.abaferas.ui.screen.onboarding.onBoardingRoute

@Composable
fun IKnowNavGraph() {
    NavHost(LocalNavController.current, startDestination = IKnowDestination.OnBoarding.route) {
        onBoardingRoute()
    }
}