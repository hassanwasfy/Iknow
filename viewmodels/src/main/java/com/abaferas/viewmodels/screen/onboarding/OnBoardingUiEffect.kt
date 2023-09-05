package com.abaferas.viewmodels.screen.onboarding

import com.abaferas.viewmodels.base.BaseUiEffect

sealed class OnBoardingUiEffect : BaseUiEffect {
    data object NavigateUP : OnBoardingUiEffect()
    data class SubmitSelected(val selected: String) : OnBoardingUiEffect()
}
