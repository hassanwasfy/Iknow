package com.abaferas.repository.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "most_popular_articles")
data class MostPopularArticleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val results: List<ResultEntity>
) {
    @Entity(tableName = "most_popular_article_result")
    data class ResultEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val url: String,
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
        @Entity(tableName = "media_entity")
        data class MediaEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val mediaMetadata: List<MediaMetadataEntity>
        ) {
            @Entity(tableName = "media_metadata_entity")
            data class MediaMetadataEntity(
                @PrimaryKey(autoGenerate = true)
                val id: Long = 0,
                val url: String
            )
        }
    }
}
