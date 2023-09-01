package com.abaferas.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abaferas.entities.TopStory
import com.abaferas.exception.IKnowException
import com.abaferas.usecase.usecase.GetTopStoriesBySectionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopStoriesViewModel @Inject constructor(
    private val getTopStoriesBySectionUseCase: GetTopStoriesBySectionUseCase
) : ViewModel(){

    private val _data: MutableStateFlow<TopStoryUiState> = MutableStateFlow(TopStoryUiState())
    val data = _data.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        val section = "home"
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _data.update {
                    TopStoryUiState(isLoading = false,data = listOf(getTopStoriesBySectionUseCase(section)))
                }
            }catch (iKnowException: IKnowException){
                _data.update {
                    TopStoryUiState(isLoading = false,isError = Pair(true,iKnowException.errorMessage))
                }
            }
        }
    }

    fun retry(){
        _data.update {
            TopStoryUiState(isLoading = true)
        }
        getData()
    }


}


data class TopStoryUiState(
    val isLoading: Boolean = true,
    val isError: Pair<Boolean,String> = Pair(false,""),
    val data: List<TopStory> = emptyList()
)
