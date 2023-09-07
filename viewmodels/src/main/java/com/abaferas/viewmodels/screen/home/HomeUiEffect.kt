package com.abaferas.viewmodels.screen.home

import com.abaferas.viewmodels.base.BaseUiEffect

sealed class HomeUiEffect : BaseUiEffect {
    data class NavigateToArticle(val id: String) : HomeUiEffect()
    data object NavigateToSearch : HomeUiEffect()
    data object NavigateToBooks : HomeUiEffect()
    data object NavigateToSaves : HomeUiEffect()

}
