package com.abaferas.repository.mapper

import com.abaferas.entities.Article
import com.abaferas.entities.ArticleList
import com.abaferas.entities.Books
import com.abaferas.entities.MostPopularArticle
import com.abaferas.entities.TopStories
import com.abaferas.repository.models.archive.DTOArticleArchive
import com.abaferas.repository.models.books.DTOBooks
import com.abaferas.repository.models.books.DTOListFullOverView
import com.abaferas.repository.models.books.DTOListOverView
import com.abaferas.repository.models.mostpopular.DTOMostPopularArticle
import com.abaferas.repository.models.search.DTOArticleSearch
import com.abaferas.repository.models.topstories.DTOTopStories

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

fun DTOListFullOverView.toDomain(): ArticleList {
    return ArticleList(
        results = ArticleList.Results(bestsellersDate = this.results.bestsellersDate ?: noData,
            publishedDate = this.results.publishedDate ?: noData,
            lists = this.results.lists.map { lists ->
                ArticleList.Results.Lists(listId = lists.listId ?: -1,
                    displayName = lists.displayName ?: noData,
                    updated = lists.updated ?: noData,
                    listImage = "${images}${lists.listId}",
                    books = lists.books.map { book ->
                        ArticleList.Results.Lists.Book(amazonProductUrl = book.amazonProductUrl
                            ?: noData,
                            author = book.author ?: noData,
                            bookImage = book.bookImage ?: noData,
                            bookReviewLink = book.bookReviewLink ?: noData,
                            contributor = book.contributor ?: noData,
                            contributorNote = book.contributorNote ?: noData,
                            createdDate = book.createdDate ?: noData,
                            description = book.description ?: noData,
                            price = book.price ?: noData,
                            primaryIsbn10 = book.primaryIsbn10 ?: noData,
                            primaryIsbn13 = book.primaryIsbn13 ?: noData,
                            publisher = book.publisher ?: noData,
                            rank = book.rank ?: -1,
                            title = book.amazonProductUrl ?: noData,
                            buyLinks = book.buyLinks.map { buy ->
                                ArticleList.Results.Lists.Book.BuyLink(
                                    name = buy.name ?: noData, url = buy.url ?: noData
                                )
                            })
                    })
            })
    )
}

fun DTOListOverView.toDomain(): ArticleList {
    return ArticleList(
        results = ArticleList.Results(bestsellersDate = this.results.bestsellersDate ?: noData,
            publishedDate = this.results.publishedDate ?: noData,
            lists = this.results.lists.map { lists ->
                ArticleList.Results.Lists(listId = lists.listId ?: -1,
                    displayName = lists.displayName ?: noData,
                    updated = lists.updated ?: noData,
                    listImage = "${images}${lists.listId}",
                    books = lists.books.map { book ->
                        ArticleList.Results.Lists.Book(amazonProductUrl = book.amazonProductUrl
                            ?: noData,
                            author = book.author ?: noData,
                            bookImage = book.bookImage ?: noData,
                            bookReviewLink = book.bookReviewLink ?: noData,
                            contributor = book.contributor ?: noData,
                            contributorNote = book.contributorNote ?: noData,
                            createdDate = book.createdDate ?: noData,
                            description = book.description ?: noData,
                            price = book.price ?: noData,
                            primaryIsbn10 = book.primaryIsbn10 ?: noData,
                            primaryIsbn13 = book.primaryIsbn13 ?: noData,
                            publisher = book.publisher ?: noData,
                            rank = book.rank ?: -1,
                            title = book.amazonProductUrl ?: noData,
                            buyLinks = book.buyLinks.map { buy ->
                                ArticleList.Results.Lists.Book.BuyLink(
                                    name = buy.name ?: noData, url = buy.url ?: noData
                                )
                            })
                    })
            })
    )
}


fun DTOMostPopularArticle.toDomain(): MostPopularArticle {
    val results = this.results.map { dtoResult ->
        MostPopularArticle.Result(url = dtoResult.url ?: "",
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
                MostPopularArticle.Result.Media(mediaMetadata = media.mediaMetadata.map {
                    MostPopularArticle.Result.Media.MediaMetadata(it.url ?: "")
                })
            })
    }
    return MostPopularArticle(results)
}

fun DTOTopStories.toDomain(): TopStories {
    return TopStories(
        lastUpdated = this.lastUpdated ?: noData,
        results = this.results.map { story ->
            TopStories.TopStory(
                section = story.section ?: noData,
                subsection = story.subsection ?: noData,
                title = story.title ?: noData,
                url = story.url ?: url404,
                updatedDate = story.updatedDate ?: noData,
                createdDate = story.createdDate ?: noData,
                publishedDate = story.publishedDate ?: noData,
                desFacet = story.desFacet.map {
                    TopStories.TopStory.Word(it)
                },
                kicker = story.kicker ?: noData,
                multimedia = story.multimedia.map {
                    TopStories.TopStory.Multimedia(it.url ?: url404)
                },
                shortUrl = story.shortUrl ?: url404
            )
        })
}


const val images = "https://www.nytimes.com/"
const val noData = "N/A"
const val url404 = "https://google.com/not-very+found"