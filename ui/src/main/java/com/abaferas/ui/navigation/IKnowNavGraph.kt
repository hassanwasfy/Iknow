package com.abaferas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.abaferas.ui.main.LocalNavController
import com.abaferas.ui.screen.home.homeRoute
import com.abaferas.ui.screen.onboarding.onBoardingRoute
import com.abaferas.ui.screen.search.searchRoute


@Composable
fun IKnowNavGraph() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = IKnowDestination.OnBoarding.route
    ) {
        onBoardingRoute()
        homeRoute()
        searchRoute()
    }
}