package com.abaferas.viewmodels.screen.home

import com.abaferas.usecase.usecase.GetTopStoriesBySectionUseCase
import com.abaferas.viewmodels.base.BaseViewModel
import com.abaferas.viewmodels.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopStoriesBySectionUseCase: GetTopStoriesBySectionUseCase
) : BaseViewModel<HomeUiState, HomeUiEffect>(HomeUiState()), HomeInteractionListener {

    init {
        getData()
    }

    private fun getData() {
        val section = "home"
        tryToExecute(
            execute = {
                getTopStoriesBySectionUseCase.invoke(section).toUiState()
            },
            onError = ::onError,
            onSuccess = ::onSuccess
        )
    }

    fun retry() {
        getData()
    }

    private fun onError(errorMsg: String) {
        iState.update {
            HomeUiState(
                isLoading = false,
                error = ErrorUiState(isError = true, errorMsg),
                data = null
            )
        }
    }

    private fun onSuccess(homeUi: HomeUi) {
        iState.update {
            HomeUiState(
                isLoading = false,
                error = null,
                data = homeUi
            )
        }
    }

}