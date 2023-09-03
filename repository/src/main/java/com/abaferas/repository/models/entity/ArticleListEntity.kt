package com.abaferas.repository.models.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_list")
data class ArticleListEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val results: ResultsEntity
) {
    @Entity(tableName = "results_entity")
    data class ResultsEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val bestsellersDate: String,
        val publishedDate: String,
        val lists: List<ListsEntity>
    ) {
        @Entity(tableName = "lists_entity")
        data class ListsEntity(
            @PrimaryKey(autoGenerate = true)
            val id: Long = 0,
            val listId: Int,
            val displayName: String,
            val updated: String,
            val listImage: String,
            val books: List<BookEntity>
        ) {
            @Entity(tableName = "book_entity")
            data class BookEntity(
                @PrimaryKey(autoGenerate = true)
                val id: Long = 0,
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
                @Entity(tableName = "buy_link_entity")
                data class BuyLinkEntity(
                    @PrimaryKey(autoGenerate = true)
                    val id: Long = 0,
                    val name: String,
                    val url: String
                )
            }
        }
    }
}


