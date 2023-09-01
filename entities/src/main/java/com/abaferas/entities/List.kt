package com.abaferas.entities

import kotlin.collections.List

data class List<T>(
    val results: Results
) {
    data class Results(
        val bestsellersDate: String,
        val publishedDate: String,
        val lists: List<Lists>
    ) {
        data class Lists(
            val listId: Int,
            val displayName: String,
            val updated: String,
            val listImage: String,
            val books: List<Book>
        ) {
            data class Book(
                val amazonProductUrl: String,
                val author: String,
                val bookImage: String,
                val bookReviewLink: String,
                val contributor: String,
                val contributorNote: String,
                val createdDate: String,
                val description: String,
                val price: String,
                val primaryIsbn10: String,
                val primaryIsbn13: String,
                val publisher: String,
                val rank: Int,
                val title: String,
                val buyLinks: List<BuyLink>
            ) {
                data class BuyLink(
                    val name: String,
                    val url: String
                )
            }
        }
    }
}

