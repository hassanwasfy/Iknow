package com.abaferas.entities

data class TopStory(
    val copyright: String,
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
            val format: String,
            val height: Int,
            val width: Int,
            val type: String,
            val subtype: String,
            val caption: String,
            val copyright: String
        )
    }
}