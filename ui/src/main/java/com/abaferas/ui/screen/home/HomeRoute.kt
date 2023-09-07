package com.abaferas.ui.screen.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.abaferas.ui.navigation.IKnowDestination
import com.abaferas.viewmodels.screen.home.HomeArgs

fun NavGraphBuilder.homeRoute() {
    composable(
        route = "${IKnowDestination.Home.route}/{${HomeArgs.SECTIONS}}",
        arguments = listOf(
            navArgument(HomeArgs.SECTIONS) {
                type = NavType.StringType
            }
        )
    ) {
        HomeScreen()
    }
}

fun NavController.navigateToHome(section: String) {
    navigate("${IKnowDestination.Home.route}/$section")
}