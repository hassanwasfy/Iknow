package com.abaferas.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abaferas.ui.navigation.IKnowDestination

fun NavGraphBuilder.homeRoute() {
    composable(
        route = IKnowDestination.Home.route,
    ) {
        HomeScreen()
    }
}

fun NavController.navigateToHome() {
    navigate(IKnowDestination.Home.route)
}