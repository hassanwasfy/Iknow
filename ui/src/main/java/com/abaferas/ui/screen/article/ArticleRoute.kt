package com.abaferas.ui.screen.article

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.abaferas.ui.navigation.IKnowDestination

fun NavGraphBuilder.articleRoute() {
    composable(
        route = IKnowDestination.Article.route,
    ) {
        ArticleScreen()
    }
}

fun NavController.navigateToArticle() {
    navigate(IKnowDestination.Article.route)
}