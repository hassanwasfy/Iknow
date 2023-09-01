package com.abaferas.entities

import kotlin.collections.List

data class Books(
    val lastModified: String,
    val results: List<Result>
) {
    data class Result(
        val displayName: String,
        val publishedDate: String,
        val rank: Int,
        val amazonProductUrl: String,
        val isbns: List<Isbn>,
        val bookDetails: List<BookDetail>,
    ) {
        data class Isbn(
            val isbn10: String,
            val isbn13: String
        )

        data class BookDetail(
            val title: String,
            val description: String,
            val contributor: String,
            val author: String,
            val contributorNote: String,
            val price: String,
            val publisher: String,
            val primaryIsbn13: String,
            val primaryIsbn10: String
        )
    }
}

