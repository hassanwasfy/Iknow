package com.abaferas.viewmodels.screen.home

import com.abaferas.entities.TopStories


data class HomeUi(
    val lastUpdated: String, val results: List<TopStories>
) {
    data class TopStories(
        val section: String,
        val subsection: String,
        val title: String,
        val url: String,
        val updatedDate: String,
        val createdDate: String,
        val publishedDate: String,
        val kicker: String,
        val multimedia: List<Multimedia>,
        val shortUrl: String
    ) {
        data class Multimedia(
            val url: String,
        )
    }
}


fun TopStories.toUiState(): HomeUi {
    return HomeUi(lastUpdated = this.lastUpdated, results = this.results.map {
        HomeUi.TopStories(
            section = it.section,
            subsection = it.subsection,
            title = it.title,
            url = it.url,
            updatedDate = it.updatedDate,
            createdDate = it.createdDate,
            publishedDate = it.publishedDate,
            kicker = it.kicker,
            multimedia = it.multimedia.map {
                HomeUi.TopStories.Multimedia(
                    url = it.url
                )
            },
            shortUrl = it.shortUrl
        )
    })
}
