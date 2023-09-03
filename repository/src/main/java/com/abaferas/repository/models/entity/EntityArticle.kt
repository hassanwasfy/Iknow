package com.abaferas.repository.models.entity


data class EntityArticle(
    val docs: List<DocEntity>,
    val hits: Int,
) {
    class DocEntity(
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
        class MultimediaEntity(
            val url: String,
        )

        class HeadlineEntity(
            val main: String,
            val kicker: String,
            val printHeadline: String,
        )

        class KeywordEntity(
            val value: String,
        )

        class BylineEntity(
            val original: String,
        )
    }
}

