package com.abaferas.ui.main

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.abaferas.ui.navigation.IKnowDestination
import com.abaferas.ui.navigation.IKnowNavGraph

val LocalNavController =
    compositionLocalOf<NavHostController> { error("No NavController found!") }

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MovieApp() {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavController provides navController) {
        Scaffold(
            bottomBar = {
                val visibility =
                    (currentDestination()?.route ?: "") in listOf(
                        IKnowDestination.Home.route,
                        IKnowDestination.Search.route,
                        IKnowDestination.Category.route,
                        IKnowDestination.Library.route,
                        IKnowDestination.FunActivities.route
                    )
                BottomNavBar(visibility)
            }
        ) {
            IKnowNavGraph()
        }
    }
}