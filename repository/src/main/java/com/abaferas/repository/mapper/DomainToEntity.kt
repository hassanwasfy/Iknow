package com.abaferas.repository.mapper

import com.abaferas.entities.Article
import com.abaferas.entities.ArticleList
import com.abaferas.entities.Books
import com.abaferas.entities.MostPopularArticle
import com.abaferas.entities.TopStories
import com.abaferas.repository.models.entity.ArticleListEntity
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.EntityArticle
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.TopStoriesEntity

fun Article.toEntity(): EntityArticle {
    return EntityArticle(docs = this.docs.map {
        EntityArticle.DocEntity(
            webUrl = "${images}${it.webUrl}",
            snippet = it.snippet ?: noData,
            leadParagraph = it.leadParagraph ?: noData,
            source = it.source ?: noData,
            multimedia = it.multimedia.map { mul ->
                EntityArticle.DocEntity.MultimediaEntity("${images}${mul.url}")
            },
            headline = EntityArticle.DocEntity.HeadlineEntity(
                main = it.headline.main ?: noData,
                kicker = it.headline.kicker ?: noData,
                printHeadline = it.headline.printHeadline ?: noData
            ),
            keywords = it.keywords.map { value ->
                EntityArticle.DocEntity.KeywordEntity(value.value ?: noData)
            },
            pubDate = it.pubDate ?: noData,
            newsDesk = it.newsDesk ?: noData,
            sectionName = it.sectionName ?: noData,
            subsectionName = it.subsectionName ?: noData,
            byline = EntityArticle.DocEntity.BylineEntity(
                original = it.byline.original ?: noData
            ),
        )
    }, hits = this.hits)
}

fun Books.toEntity(): BooksEntity {
    return BooksEntity(lastModified = this.lastModified, results = this.results.map { result ->
        BooksEntity.ResultEntity(displayName = result.displayName,
            publishedDate = result.publishedDate,
            rank = result.rank,
            amazonProductUrl = "${images}${result.amazonProductUrl}",
            isbns = result.isbns.map {
                BooksEntity.ResultEntity.IsbnEntity(it.isbn10, it.isbn13)
            },
            bookDetails = result.bookDetails.map { details ->
                BooksEntity.ResultEntity.BookDetailEntity(
                    title = details.title,
                    description = details.description,
                    contributor = details.contributor,
                    author = details.author,
                    contributorNote = details.contributorNote,
                    price = details.price,
                    publisher = details.publisher,
                    primaryIsbn13 = details.primaryIsbn13,
                    primaryIsbn10 = details.primaryIsbn10
                )
            })
    })
}

fun ArticleList.toEntity(): ArticleListEntity {
    return ArticleListEntity(
        results = ArticleListEntity.ResultsEntity(bestsellersDate = this.results.bestsellersDate,
            publishedDate = this.results.publishedDate,
            lists = this.results.lists.map { lists ->
                ArticleListEntity.ResultsEntity.ListsEntity(listId = lists.listId ?: -1,
                    displayName = lists.displayName,
                    updated = lists.updated,
                    listImage = "${images}${lists.listId}",
                    books = lists.books.map { book ->
                        ArticleListEntity.ResultsEntity.ListsEntity.BookEntity(amazonProductUrl = book.amazonProductUrl
                            ?: noData,
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
                            title = book.amazonProductUrl,
                            buyLinks = book.buyLinks.map { buy ->
                                ArticleListEntity.ResultsEntity.ListsEntity.BookEntity.BuyLinkEntity(
                                    name = buy.name, url = buy.url
                                )
                            })
                    })
            })
    )
}

fun MostPopularArticle.toEntity(): MostPopularArticleEntity {
    val results = this.results.map { dtoResult ->
        MostPopularArticleEntity.ResultEntity(url = dtoResult.url ?: noData,
            id = dtoResult.id,
            source = dtoResult.source,
            updated = dtoResult.updated,
            section = dtoResult.section,
            subsection = dtoResult.subsection,
            adxKeywords = dtoResult.adxKeywords,
            column = dtoResult.column,
            byline = dtoResult.byline,
            type = dtoResult.type,
            title = dtoResult.title,
            abstract = dtoResult.`abstract`,
            media = dtoResult.media.map { media ->
                MostPopularArticleEntity.ResultEntity.MediaEntity(mediaMetadata = media.mediaMetadata.map {
                    MostPopularArticleEntity.ResultEntity.MediaEntity.MediaMetadataEntity(it.url)
                })
            })
    }
    return MostPopularArticleEntity(results)
}

fun TopStories.toEntity(): TopStoriesEntity {
    return TopStoriesEntity(
        lastUpdated = this.lastUpdated,
        results = this.results.map { story ->
            TopStoriesEntity.TopStoryEntity(
                section = story.section,
                subsection = story.subsection,
                title = story.title,
                url = story.url,
                byLine = story.byLine,
                updatedDate = story.updatedDate,
                createdDate = story.createdDate,
                publishedDate = story.publishedDate,
                desFacet = story.desFacet.map {
                    TopStoriesEntity.TopStoryEntity.WordEntity(it.name)
                },
                kicker = story.kicker,
                multimedia = story.multimedia.map {
                    TopStoriesEntity.TopStoryEntity.MultimediaEntity(it.url)
                },
                shortUrl = story.shortUrl
            )
        })
}
