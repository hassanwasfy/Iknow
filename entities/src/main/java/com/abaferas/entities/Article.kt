package com.abaferas.entities

import kotlin.collections.List


data class Article(
    val docs: List<Doc>,
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
        val hits: Int,
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

