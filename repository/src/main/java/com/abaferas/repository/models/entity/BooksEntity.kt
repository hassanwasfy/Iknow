package com.abaferas.repository.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BooksEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val lastModified: String,
    val results: List<ResultEntity>
) {
    @Entity(tableName = "book_result")
    data class ResultEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val displayName: String,
        val publishedDate: String,
        val rank: Int,
        val amazonProductUrl: String,
        val isbns: List<IsbnEntity>,
        val bookDetails: List<BookDetailEntity>
    ) {
        @Entity(tableName = "isbn_entity")
        data class IsbnEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val isbn10: String,
            val isbn13: String
        )

        @Entity(tableName = "book_detail_entity")
        data class BookDetailEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
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


