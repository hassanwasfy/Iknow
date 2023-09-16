package com.abaferas.repository.models.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity
data class BooksEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var lastModified: String = ""
) {
    @Embedded
    var results: List<IResult> = emptyList()
}

@Entity
data class IResult(
    @PrimaryKey(autoGenerate = true)
    var resultId: Long = 0L,
    var displayName: String = "",
    var publishedDate: String = "",
    var rank: Int = 0,
    var amazonProductUrl: String = ""
) {
    @Relation(
        parentColumn = "resultId",
        entityColumn = "resultOwnerId"
    )
    var isbns: List<IIsbn> = emptyList()

    @Relation(
        parentColumn = "resultId",
        entityColumn = "resultOwnerId"
    )
    var bookDetails: List<IBookDetail> = emptyList()
}

@Entity
data class IIsbn(
    @PrimaryKey(autoGenerate = true)
    var isbnId: Long = 0L,
    var isbn10: String = "",
    var isbn13: String = "",
    var resultOwnerId: Long = 0L
)

@Entity
data class IBookDetail(
    @PrimaryKey(autoGenerate = true)
    var bookDetailId: Long = 0L,
    var title: String = "",
    var description: String = "",
    var contributor: String = "",
    var author: String = "",
    var contributorNote: String = "",
    var price: String = "",
    var publisher: String = "",
    var primaryIsbn13: String = "",
    var primaryIsbn10: String = "",
    var resultOwnerId: Long = 0L
)



