package com.abaferas.viewmodels.screen.home

import com.abaferas.viewmodels.base.IBaseInteractionListener


interface HomeInteractionListener : IBaseInteractionListener {
    fun onClickArticle(id: String)
}

