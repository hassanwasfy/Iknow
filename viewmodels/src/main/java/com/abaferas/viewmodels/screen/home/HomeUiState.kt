package com.abaferas.viewmodels.screen.home

import com.abaferas.viewmodels.base.BaseUiState
import com.abaferas.viewmodels.base.ErrorUiState

data class HomeUiState(
    val isLoading: Boolean = true,
    val error: ErrorUiState? = null,
    val data: HomeUi? = null
) : BaseUiState
