package com.abaferas.repository.mapper

import com.abaferas.entities.ArticleList
import com.abaferas.repository.models.entity.ArticleListEntity

fun ArticleList.toArticleListEntity(): ArticleListEntity {
    val resultsEntity = ArticleListEntity.BResults(
        bestsellersDate = results.bestsellersDate,
        publishedDate = results.publishedDate,
        lists = results.lists.map { list ->
            ArticleListEntity.BResults.BLists(
                listId = list.listId,
                displayName = list.displayName,
                updated = list.updated,
                listImage = list.listImage,
                books = list.books.map { book ->
                    ArticleListEntity.BResults.BLists.BBook(
                        amazonProductUrl = book.amazonProductUrl,
                        author = book.author,
                        bookImage = book.bookImage,
                        bookReviewLink = book.bookReviewLink,
                        contributor = book.contributor,
                        contributorNote = book.contributorNote,
                        createdDate = book.createdDate,
                        description = book.description,
                        price = book.price,
                        primaryIsbn10 = book.primaryIsbn10,
                        primaryIsbn13 = book.primaryIsbn13,
                        publisher = book.publisher,
                        rank = book.rank,
                        title = book.title,
                        buyLinks = book.buyLinks.map { buyLink ->
                            ArticleListEntity.BResults.BLists.BBook.BBuyLink(
                                name = buyLink.name,
                                url = buyLink.url
                            )
                        }
                    )
                }
            )
        }
    )

    return ArticleListEntity(results = resultsEntity)
}

fun ArticleListEntity.toArticleList(): ArticleList {
    val results = ArticleList.Results(
        bestsellersDate = this.results.bestsellersDate,
        publishedDate = this.results.publishedDate,
        lists = this.results.lists.map { list ->
            ArticleList.Results.Lists(
                listId = list.listId,
                displayName = list.displayName,
                updated = list.updated,
                listImage = list.listImage,
                books = list.books.map { book ->
                    ArticleList.Results.Lists.Book(
                        amazonProductUrl = book.amazonProductUrl,
                        author = book.author,
                        bookImage = book.bookImage,
                        bookReviewLink = book.bookReviewLink,
                        contributor = book.contributor,
                        contributorNote = book.contributorNote,
                        createdDate = book.createdDate,
                        description = book.description,
                        price = book.price,
                        primaryIsbn10 = book.primaryIsbn10,
                        primaryIsbn13 = book.primaryIsbn13,
                        publisher = book.publisher,
                        rank = book.rank,
                        title = book.title,
                        buyLinks = book.buyLinks.map { buyLink ->
                            ArticleList.Results.Lists.Book.BuyLink(
                                name = buyLink.name,
                                url = buyLink.url
                            )
                        }
                    )
                }
            )
        }
    )

    return ArticleList(results = results)
}
