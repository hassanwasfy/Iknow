package com.abaferas.ui.screen.search

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abaferas.ui.navigation.IKnowDestination

fun NavGraphBuilder.searchRoute() {
    composable(route = IKnowDestination.Search.route) {
        SearchScreen()
    }
}

fun NavController.navigateToSearch() {
    navigate(IKnowDestination.Search.route)
}