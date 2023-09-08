package com.abaferas.viewmodels.screen.onboarding

import android.util.Log
import com.abaferas.usecase.usecase.GetOnBoardingSectionsUseCase
import com.abaferas.viewmodels.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val getOnBoardingSectionsUseCase: GetOnBoardingSectionsUseCase
) : BaseViewModel<OnBoardingUi, OnBoardingUiEffect>(OnBoardingUi()), OnBoardingInteraction {


    private val _selected: MutableStateFlow<MutableList<String>> = MutableStateFlow(mutableListOf())
    val selected = _selected.asStateFlow()

    init {
        Log.i("x010", "OnBoardStart")
        getData()
    }

    override fun getData() {
        iState.update {
            OnBoardingUi(
                isLoading = false,
                list = getOnBoardingSectionsUseCase.invoke().map { Item(it) }.toMutableList()
            )
        }
    }

    override fun onClickBack() {
        sendUiEffect(OnBoardingUiEffect.NavigateUP)
    }

    override fun onClickSubmit() {
        val choices = selected.value.joinToString(",")
        sendUiEffect(OnBoardingUiEffect.SubmitSelected(choices))
    }

    override fun toggleItem(item: Item) {
        if (_selected.value.contains(item.name)) {
            _selected.value.remove(item.name)
        } else {
            _selected.value.add(item.name)
        }
    }
}


data class Item(
    val name: String,
    var selected: Boolean = false
)