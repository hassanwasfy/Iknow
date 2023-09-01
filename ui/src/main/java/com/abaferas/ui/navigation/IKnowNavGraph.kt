package com.abaferas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.abaferas.ui.main.LocalNavController

@Composable
fun IKnowNavGraph() {
    NavHost(LocalNavController.current, startDestination = IKnowDestination.Home.route) {

    }
}