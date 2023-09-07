package com.abaferas.viewmodels.screen.home

import androidx.lifecycle.SavedStateHandle

class HomeArgs(savedStateHandle: SavedStateHandle) {
    val sections: String = savedStateHandle[SECTIONS] ?: "home"

    companion object {
        const val SECTIONS = "sections"
    }
}