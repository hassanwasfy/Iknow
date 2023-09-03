package com.abaferas.repository.models.entity

data class ArticleListEntity(
    val results: ResultsEntity
) {
    data class ResultsEntity(
        val bestsellersDate: String,
        val publishedDate: String,
        val lists: List<ListsEntity>
    ) {
        data class ListsEntity(
            val listId: Int,
            val displayName: String,
            val updated: String,
            val listImage: String,
            val books: List<BookEntity>
        ) {
            data class BookEntity(
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
                val buyLinks: List<BuyLinkEntity>
            ) {
                data class BuyLinkEntity(
                    val name: String,
                    val url: String
                )
            }
        }
    }
}

