package com.abaferas.viewmodels.screen.onboarding

import com.abaferas.viewmodels.base.BaseUiState

data class OnBoardingUi(
    val title: String = "What are your interests ?!",
    val note: String = "Explore your preferred news section by selecting from below. Simply tap on the section that interests you to access the latest articles and updates in that category.",
    val list: MutableList<Item> = mutableListOf(),
    val isLoading: Boolean = true,
) : BaseUiState
