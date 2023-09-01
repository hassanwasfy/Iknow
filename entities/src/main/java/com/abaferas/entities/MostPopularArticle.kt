package com.abaferas.entities

import  kotlin.collections.List

data class MostPopularArticle(
    val results: List<Result>
) {
    data class Result(
        val url: String,
        val id: Long,
        val source: String,
        val updated: String,
        val section: String,
        val subsection: String,
        val adxKeywords: String,
        val column: String,
        val byline: String,
        val type: String,
        val title: String,
        val abstract: String,
        val media: List<Media>,
    ) {
        data class Media(
            val mediaMetadata: List<MediaMetadata>
        ) {
            data class MediaMetadata(
                val url: String
            )
        }
    }
}
