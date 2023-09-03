package com.abaferas.repository.models.entity

data class BooksEntity(
    val lastModified: String,
    val results: List<ResultEntity>
) {
    data class ResultEntity(
        val displayName: String,
        val publishedDate: String,
        val rank: Int,
        val amazonProductUrl: String,
        val isbns: List<IsbnEntity>,
        val bookDetails: List<BookDetailEntity>,
    ) {
        data class IsbnEntity(
            val isbn10: String,
            val isbn13: String
        )

        data class BookDetailEntity(
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

