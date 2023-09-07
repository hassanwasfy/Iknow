package com.abaferas.viewmodels.screen.home

import androidx.lifecycle.SavedStateHandle
import com.abaferas.usecase.usecase.GetTopStoriesBySectionUseCase
import com.abaferas.viewmodels.base.BaseViewModel
import com.abaferas.viewmodels.base.ErrorUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopStoriesBySectionUseCase: GetTopStoriesBySectionUseCase,
    savedStateHandle: SavedStateHandle
) : BaseViewModel<HomeUiState, HomeUiEffect>(HomeUiState()), HomeInteractionListener {

    private val args: HomeArgs = HomeArgs(savedStateHandle)

    init {
        getData()
    }

    private fun getData() {
        tryToExecute(
            execute = {
                getTopStoriesBySectionUseCase.invoke(args.sections).toUiState()
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

    override fun onClickSearch() {
        sendUiEffect(HomeUiEffect.NavigateToSearch)
    }

    override fun onClickBooks() {
        sendUiEffect(HomeUiEffect.NavigateToBooks)
    }

    override fun onClickSaves() {
        sendUiEffect(HomeUiEffect.NavigateToSaves)
    }
}