package com.abaferas.repository.models.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class ArticleListEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    @Embedded
    var results: BResults = BResults()
) {
    @Entity
    data class BResults(
        @PrimaryKey(autoGenerate = true)
        var resultsId: Long = 0L,
        var bestsellersDate: String = "",
        var publishedDate: String = "",
        @Relation(
            parentColumn = "resultsId",
            entityColumn = "resultsOwnerId"
        )
        var lists: List<BLists> = emptyList()
    ) {
        @Entity
        data class BLists(
            @PrimaryKey(autoGenerate = true)
            var listsId: Long = 0L,
            var listId: Int = 0,
            var displayName: String = "",
            var updated: String = "",
            var listImage: String = "",
            @Relation(
                parentColumn = "listsId",
                entityColumn = "listsOwnerId"
            )
            var books: List<BBook> = emptyList()
        ) {

            @Entity
            data class BBook(
                @PrimaryKey(autoGenerate = true)
                var bookId: Long = 0L,
                var amazonProductUrl: String = "",
                var author: String = "",
                var bookImage: String = "",
                var bookReviewLink: String = "",
                var contributor: String = "",
                var contributorNote: String = "",
                var createdDate: String = "",
                var description: String = "",
                var price: String = "",
                var primaryIsbn10: String = "",
                var primaryIsbn13: String = "",
                var publisher: String = "",
                var rank: Int = 0,
                var title: String = "",
                @Relation(
                    parentColumn = "bookId",
                    entityColumn = "booksOwnerId"
                )
                var buyLinks: List<BBuyLink> = emptyList()
            ) {
                @Entity
                data class BBuyLink(
                    @PrimaryKey(autoGenerate = true)
                    var buyLinkId: Long = 0L,
                    var name: String = "",
                    var url: String = "",
                    var booksOwnerId: Long = 0L
                )
            }
        }
    }
}