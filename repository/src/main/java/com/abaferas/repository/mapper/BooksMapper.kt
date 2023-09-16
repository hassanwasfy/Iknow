package com.abaferas.repository.mapper

import com.abaferas.entities.Books
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.IBookDetail
import com.abaferas.repository.models.entity.IIsbn
import com.abaferas.repository.models.entity.IResult

fun BooksEntity.toBooks(): Books {
    val books = Books(
        lastModified = this.lastModified,
        results = this.results.map { iResult ->
            Books.Result(
                displayName = iResult.displayName,
                publishedDate = iResult.publishedDate,
                rank = iResult.rank,
                amazonProductUrl = iResult.amazonProductUrl,
                isbns = iResult.isbns.map { iIsbn ->
                    Books.Result.Isbn(
                        isbn10 = iIsbn.isbn10,
                        isbn13 = iIsbn.isbn13
                    )
                },
                bookDetails = iResult.bookDetails.map { iBookDetail ->
                    Books.Result.BookDetail(
                        title = iBookDetail.title,
                        description = iBookDetail.description,
                        contributor = iBookDetail.contributor,
                        author = iBookDetail.author,
                        contributorNote = iBookDetail.contributorNote,
                        price = iBookDetail.price,
                        publisher = iBookDetail.publisher,
                        primaryIsbn13 = iBookDetail.primaryIsbn13,
                        primaryIsbn10 = iBookDetail.primaryIsbn10
                    )
                }
            )
        }
    )
    return books
}

fun Books.toBooksEntity(): BooksEntity {
    val booksEntity = BooksEntity()
    booksEntity.lastModified = this.lastModified
    booksEntity.results = this.results.map { result ->
        val iResult = IResult(
            displayName = result.displayName,
            publishedDate = result.publishedDate,
            rank = result.rank,
            amazonProductUrl = result.amazonProductUrl
        )
        iResult.isbns = result.isbns.map { isbn ->
            IIsbn(
                isbn10 = isbn.isbn10,
                isbn13 = isbn.isbn13
            )
        }
        iResult.bookDetails = result.bookDetails.map { bookDetail ->
            IBookDetail(
                title = bookDetail.title,
                description = bookDetail.description,
                contributor = bookDetail.contributor,
                author = bookDetail.author,
                contributorNote = bookDetail.contributorNote,
                price = bookDetail.price,
                publisher = bookDetail.publisher,
                primaryIsbn13 = bookDetail.primaryIsbn13,
                primaryIsbn10 = bookDetail.primaryIsbn10
            )
        }
        iResult
    }
    return booksEntity
}
