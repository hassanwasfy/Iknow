package com.abaferas.repository.models.entity

data class MostPopularArticleEntity(
    val results: List<ResultEntity>
) {
    data class ResultEntity(
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
        val media: List<MediaEntity>,
    ) {
        data class MediaEntity(
            val mediaMetadata: List<MediaMetadataEntity>
        ) {
            data class MediaMetadataEntity(
                val url: String
            )
        }
    }
}
