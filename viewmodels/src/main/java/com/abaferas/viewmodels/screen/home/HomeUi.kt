package com.abaferas.viewmodels.screen.home

import com.abaferas.entities.TopStories


data class HomeUi(
    val results: List<TopStories>
) {
    data class TopStories(
        val section: String,
        val title: String,
        val url: String
    )
}


fun TopStories.toUiState(): HomeUi {
    return HomeUi(
        results = this.results.map {
            HomeUi.TopStories(
                section = it.section,
                title = it.title,
                url = if (it.multimedia.isNotEmpty()) it.multimedia[0].url else image,
            )
        })
}


val image =
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzbFddHOUce6F3iOsBlTFKZnyRMh18IIZeX6JQbzxR&s"