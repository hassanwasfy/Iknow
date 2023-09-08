package com.abaferas.viewmodels.screen.story

import com.abaferas.viewmodels.base.BaseUiEffect

sealed class StoryUiEffect : BaseUiEffect {
    data object NavigateHome : StoryUiEffect()
    data object NavigateToUrl : StoryUiEffect()
}