package com.abaferas.entities

data class TopStories(
    val results: List<TopStory>
) {
    data class TopStory(
        val section: String,
        val subsection: String,
        val title: String,
        val url: String,
        val byLine: String,
        val updatedDate: String,
        val createdDate: String,
        val publishedDate: String,
        val desFacet: List<Word>,
        val kicker: String,
        val multimedia: List<Multimedia>,
        val shortUrl: String
    ) {
        data class Multimedia(
            val url: String,
        )

        data class Word(
            val name: String
        )
    }
}