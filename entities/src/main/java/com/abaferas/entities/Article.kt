package com.abaferas.entities


data class Article(
    val docs: List<Doc>,
    val hits: Int
) {
    class Doc(
        val webUrl: String,
        val snippet: String,
        val leadParagraph: String,
        val source: String,
        val multimedia: List<Multimedia>,
        val headline: Headline,
        val keywords: List<Keyword>,
        val pubDate: String,
        val newsDesk: String,
        val sectionName: String,
        val subsectionName: String,
        val byline: Byline,
    ) {
        class Multimedia(
            val url: String,
        )

        class Headline(
            val main: String,
            val kicker: String,
            val printHeadline: String,
        )

        class Keyword(
            val value: String,
        )

        class Byline(
            val original: String,
        )
    }
}

