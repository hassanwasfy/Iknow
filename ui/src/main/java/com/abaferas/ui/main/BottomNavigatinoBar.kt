package com.abaferas.ui.main

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.abaferas.ui.navigation.IKnowDestination
import com.abaferas.ui.theme.color
import com.abaferas.ui.theme.dimens
import com.abaferas.ui.theme.info600
import kotlin.system.exitProcess

@Composable
fun currentDestination(): NavDestination? {
    val navBackStackEntry by LocalNavController.current.currentBackStackEntryAsState()
    return navBackStackEntry?.destination
}

@Composable
fun BottomNavBar(visibility: Boolean) {
    val items by remember {
        mutableStateOf(
            listOf(
                IKnowDestination.Home,
                IKnowDestination.Search,
                IKnowDestination.Saves,
                IKnowDestination.Books,
            )
        )
    }

    AnimatedVisibility(visibility) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.dimens.dimens70)
                .background(MaterialTheme.color.white)
                .shadow(
                    elevation = MaterialTheme.dimens.dimens2,
                    clip = false,
                )
                .drawBehind {
                    val strokeWidth = 2f
                    drawLine(
                        color = Color.White,
                        start = Offset(-size.width, 0f),
                        end = Offset(size.width, 1f),
                        strokeWidth = strokeWidth
                    )
                },

            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEach { screen ->
                BottomNavItem(
                    screen = screen,
                    currentDestination = currentDestination(),
                )
            }
        }
    }

}

@Composable
fun BottomNavItem(
    screen: IKnowDestination,
    currentDestination: NavDestination?,
) {
    val navController = LocalNavController.current
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
    BackHandler {
        if (currentDestination?.route == IKnowDestination.Home.route) {
            exitProcess(0)
        } else {
            navController.navigate(IKnowDestination.Home.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    inclusive = true
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
    }
    Icon(
        modifier = Modifier
            .clickable {
                navController.navigate(screen.route) {
                    navController.graph.startDestinationRoute?.let {
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = true
                            saveState = true
                        }
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            },
        painter = painterResource(if (selected) screen.isSelected!! else screen.isUnSelected!!),
        contentDescription = "",
        tint = info600
    )
}