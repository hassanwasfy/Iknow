package com.abaferas.entities

import kotlin.collections.List

data class TopStory(
    val lastUpdated: String,
    val results: List<TopStories>
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