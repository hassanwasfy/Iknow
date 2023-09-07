package com.abaferas.ui.navigation

import com.abaferas.ui.R

sealed class IKnowDestination(
    val route: String,
    val isSelected: Int? = null,
    val isUnSelected: Int? = null
) {
    data object OnBoarding : IKnowDestination("boarding_screen")


    data object Home : IKnowDestination(
        "home_screen",
        R.drawable.home_2,
        R.drawable.home_2_1
    )

    data object Search : IKnowDestination(
        "search_screen",
        R.drawable.search_normal_1,
        R.drawable.search_normal_1_1
    )

    data object Saves : IKnowDestination(
        "saved_screen",
        R.drawable.save_2,
        R.drawable.save_2_1
    )

    data object Books : IKnowDestination(
        "books_screen",
        R.drawable.book_saved,
        R.drawable.book_saved_1
    )
}