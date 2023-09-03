package com.abaferas.repository.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "top_stories")
data class TopStoriesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val lastUpdated: String,
    val results: List<TopStoryEntity>
) {
    @Entity(tableName = "top_story")
    data class TopStoryEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
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
        @Entity(tableName = "multimedia")
        data class MultimediaEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val url: String
        )

        @Entity(tableName = "word")
        data class WordEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val name: String
        )
    }
}
