package com.abaferas.repository.models.entity

data class TopStoriesEntity(
    val lastUpdated: String,
    val results: List<TopStoryEntity>
) {
    data class TopStoryEntity(
        val section: String,
        val subsection: String,
        val title: String,
        val url: String,
        val byLine: String,
        val updatedDate: String,
        val createdDate: String,
        val publishedDate: String,
        val desFacet: List<WordEntity>,
        val kicker: String,
        val multimedia: List<MultimediaEntity>,
        val shortUrl: String
    ) {
        data class MultimediaEntity(
            val url: String,
        )

        data class WordEntity(
            val name: String
        )
    }
}