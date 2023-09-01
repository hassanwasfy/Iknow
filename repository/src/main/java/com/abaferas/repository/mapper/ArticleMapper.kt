package com.abaferas.repository.mapper

import com.abaferas.entities.Article
import com.abaferas.entities.Books
import com.abaferas.entities.List
import com.abaferas.entities.MostPopularArticle
import com.abaferas.repository.models.archive.DTOArticleArchive
import com.abaferas.repository.models.books.DTOBooks
import com.abaferas.repository.models.books.DTOListFullOverView
import com.abaferas.repository.models.books.DTOListOverView
import com.abaferas.repository.models.mostpopular.DTOMostPopularArticle
import com.abaferas.repository.models.search.DTOArticleSearch

fun DTOArticleArchive.toDomain(): Article {
    return Article(docs = this.response.docs.map {
        Article.Doc(
            webUrl = "${images}${it.webUrl}",
            snippet = it.snippet ?: noData,
            leadParagraph = it.leadParagraph ?: noData,
            source = it.source ?: noData,
            multimedia = it.multimedia.map { mul ->
                Article.Doc.Multimedia("${images}${mul.url}")
            },
            headline = Article.Doc.Headline(
                main = it.headline.main ?: noData,
                kicker = it.headline.kicker ?: noData,
                printHeadline = it.headline.printHeadline ?: noData
            ),
            keywords = it.keywords.map { value ->
                Article.Doc.Keyword(value.value ?: noData)
            },
            pubDate = it.pubDate ?: noData,
            newsDesk = it.newsDesk ?: noData,
            sectionName = it.sectionName ?: noData,
            subsectionName = it.subsectionName ?: noData,
            byline = Article.Doc.Byline(
                original = it.byline.original ?: noData
            ),
            hits = this.response.meta.hits ?: 0
        )
    })
}

fun DTOArticleSearch.toDomain(): Article {
    return Article(docs = this.response.docs.map {
        Article.Doc(
            webUrl = "${images}${it.webUrl}",
            snippet = it.snippet ?: noData,
            leadParagraph = it.leadParagraph ?: noData,
            source = it.source ?: noData,
            multimedia = it.multimedia.map { mul ->
                Article.Doc.Multimedia("${images}${mul.url}")
            },
            headline = Article.Doc.Headline(
                main = it.headline.main ?: noData,
                kicker = it.headline.kicker ?: noData,
                printHeadline = it.headline.printHeadline ?: noData
            ),
            keywords = it.keywords.map { value ->
                Article.Doc.Keyword(value.value ?: noData)
            },
            pubDate = it.pubDate ?: noData,
            newsDesk = it.newsDesk ?: noData,
            sectionName = it.sectionName ?: noData,
            subsectionName = it.subsectionName ?: noData,
            byline = Article.Doc.Byline(
                original = it.byline.original ?: noData
            ),
            hits = this.response.meta.hits ?: 0
        )
    })
}

fun DTOBooks.toDomain(): Books {
    return Books(lastModified = this.lastModified ?: noData, results = this.results.map { result ->
        Books.Result(displayName = result.displayName ?: noData,
            publishedDate = result.publishedDate ?: noData,
            rank = result.rank ?: 0,
            amazonProductUrl = "${images}${result.amazonProductUrl}",
            isbns = result.isbns.map {
                Books.Result.Isbn(it.isbn10 ?: noData, it.isbn13 ?: noData)
            },
            bookDetails = result.bookDetails.map { details ->
                Books.Result.BookDetail(
                    title = details.title ?: noData,
                    description = details.description ?: noData,
                    contributor = details.contributor ?: noData,
                    author = details.author ?: noData,
                    contributorNote = details.contributorNote ?: noData,
                    price = details.price ?: noData,
                    publisher = details.publisher ?: noData,
                    primaryIsbn13 = details.primaryIsbn13 ?: noData,
                    primaryIsbn10 = details.primaryIsbn10 ?: noData
                )
            })
    })
}

fun DTOListFullOverView.toDomain(): List<Any?> {
    val results = this.results
    val lists = results.lists.map { dtoList ->
        val books = dtoList.books.map { dtoBook ->
            List.Results.Lists.Book(
                amazonProductUrl = "${images}${dtoBook.amazonProductUrl}",
                author = dtoBook.author ?: noData,
                bookImage = "${images}${dtoBook.bookImage}",
                bookReviewLink = "${images}${dtoBook.bookReviewLink}",
                contributor = dtoBook.contributor ?: noData,
                contributorNote = dtoBook.contributorNote ?: noData,
                createdDate = dtoBook.createdDate ?: noData,
                description = dtoBook.description ?: noData,
                price = dtoBook.price ?: noData,
                primaryIsbn10 = dtoBook.primaryIsbn10 ?: noData,
                primaryIsbn13 = dtoBook.primaryIsbn13 ?: noData,
                publisher = dtoBook.publisher ?: noData,
                rank = dtoBook.rank ?: 0,
                title = dtoBook.title ?: noData,
                buyLinks = dtoBook.buyLinks.map { dtoBuyLink ->
                    List.Results.Lists.Book.BuyLink(
                        name = dtoBuyLink.name ?: noData,
                        url = "${images}${dtoBuyLink.url}"
                    )
                }
            )
        }

        List.Results.Lists(
            listId = dtoList.listId ?: 0,
            displayName = dtoList.displayName ?: noData,
            updated = dtoList.updated ?: "",
            listImage = "${images}${dtoList.listImage}",
            books = books
        )
    }

    return List(
        List.Results(
            bestsellersDate = results.bestsellersDate ?: noData,
            publishedDate = results.publishedDate ?: noData,
            lists = lists
        )
    )
}

fun DTOListOverView.toDomain(): List<Any?> {
    val results = this.results
    val lists = results.lists.map { dtoList ->
        val books = dtoList.books.map { dtoBook ->
            List.Results.Lists.Book(
                amazonProductUrl = "${images}${dtoBook.amazonProductUrl}",
                author = dtoBook.author ?: noData,
                bookImage = "${images}${dtoBook.bookImage}",
                bookReviewLink = "${images}${dtoBook.bookReviewLink}",
                contributor = dtoBook.contributor ?: noData,
                contributorNote = dtoBook.contributorNote ?: noData,
                createdDate = dtoBook.createdDate ?: noData,
                description = dtoBook.description ?: noData,
                price = dtoBook.price ?: noData,
                primaryIsbn10 = dtoBook.primaryIsbn10 ?: noData,
                primaryIsbn13 = dtoBook.primaryIsbn13 ?: noData,
                publisher = dtoBook.publisher ?: noData,
                rank = dtoBook.rank ?: 0,
                title = dtoBook.title ?: noData,
                buyLinks = dtoBook.buyLinks.map { dtoBuyLink ->
                    List.Results.Lists.Book.BuyLink(
                        name = dtoBuyLink.name ?: noData,
                        url = "${images}${dtoBuyLink.url}"
                    )
                }
            )
        }

        List.Results.Lists(
            listId = dtoList.listId ?: 0,
            displayName = dtoList.displayName ?: noData,
            updated = dtoList.updated ?: "",
            listImage = "${images}${dtoList.listImage}",
            books = books
        )
    }

    return List(
        List.Results(
            bestsellersDate = results.bestsellersDate ?: noData,
            publishedDate = results.publishedDate ?: noData,
            lists = lists
        )
    )
}


fun DTOMostPopularArticle.toDomain(): MostPopularArticle {
    val results = this.results.map { dtoResult ->
        MostPopularArticle.Result(
            url = dtoResult.url ?: "",
            id = dtoResult.id ?: 0,
            source = dtoResult.source ?: "",
            updated = dtoResult.updated ?: "",
            section = dtoResult.section ?: "",
            subsection = dtoResult.subsection ?: "",
            adxKeywords = dtoResult.adxKeywords ?: "",
            column = dtoResult.column ?: "",
            byline = dtoResult.byline ?: "",
            type = dtoResult.type ?: "",
            title = dtoResult.title ?: "",
            abstract = dtoResult.`abstract` ?: "",
            media = dtoResult.media.map { media ->
                MostPopularArticle.Result.Media(
                    mediaMetadata = media.mediaMetadata.map {
                        MostPopularArticle.Result.Media.MediaMetadata(it.url ?: "")
                    }
                )
            }
        )
    }
    return MostPopularArticle(results)
}


const val images = "https://www.nytimes.com/"
const val noData = "N/A"