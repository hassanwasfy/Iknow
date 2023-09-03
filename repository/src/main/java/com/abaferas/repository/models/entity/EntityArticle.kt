package com.abaferas.repository.models.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entity_articles")
data class EntityArticle(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val docs: List<DocEntity>,
    val hits: Int
) {
    @Entity(tableName = "doc_entity")
    data class DocEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val webUrl: String,
        val snippet: String,
        val leadParagraph: String,
        val source: String,
        val multimedia: List<MultimediaEntity>,
        val headline: HeadlineEntity,
        val keywords: List<KeywordEntity>,
        val pubDate: String,
        val newsDesk: String,
        val sectionName: String,
        val subsectionName: String,
        val byline: BylineEntity,
    ) {
        @Entity(tableName = "multimedia_entity")
        data class MultimediaEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val url: String,
        )

        @Entity(tableName = "headline_entity")
        data class HeadlineEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val main: String,
            val kicker: String,
            val printHeadline: String,
        )

        @Entity(tableName = "keyword_entity")
        data class KeywordEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val value: String,
        )

        @Entity(tableName = "byline_entity")
        data class BylineEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val original: String,
        )
    }
}


