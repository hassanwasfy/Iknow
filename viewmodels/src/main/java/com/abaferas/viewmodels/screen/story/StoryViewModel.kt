package com.abaferas.viewmodels.screen.story

import com.abaferas.usecase.usecase.GetTopStoriesBySectionUseCase
import com.abaferas.viewmodels.base.BaseViewModel
import com.abaferas.viewmodels.base.ErrorUiState
import com.abaferas.viewmodels.screen.home.toUiState
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class StoryViewModel @Inject constructor(
    private val getTopStoriesBySectionUseCase: GetTopStoriesBySectionUseCase
) : BaseViewModel<StoryUiState, StoryUiEffect>(StoryUiState()), StoryInteractionListener {
    override fun getData() {
        tryToExecute(
            execute = { getTopStoriesBySectionUseCase("home").toUiState().results[0] },
            onSuccess = ::onSuccess,
            onError = ::onError
        )
    }

    init {
        getData()
    }

    private fun handleData() {

    }

    private fun onError(errorMsg: String) {
        iState.update {
            StoryUiState(
                isLoading = false,
                isError = ErrorUiState(isError = true, errorMsg),
            )
        }
    }

    private fun onSuccess(story: Story) {
        iState.update {
            StoryUiState(
                isLoading = false,
                isError = null,
                story = story
            )
        }
    }

    override fun onClickBack() {
        sendUiEffect(StoryUiEffect.NavigateHome)
    }

    override fun onClickLink() {
        sendUiEffect(StoryUiEffect.NavigateToUrl)
    }
}