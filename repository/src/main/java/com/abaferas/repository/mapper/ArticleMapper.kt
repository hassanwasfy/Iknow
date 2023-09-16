package com.abaferas.repository.mapper

import com.abaferas.entities.Article
import com.abaferas.repository.models.entity.ArticleEntity

fun Article.Doc.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        webUrl = webUrl,
        snippet = snippet,
        leadParagraph = leadParagraph,
        source = source,
        multimedia = multimedia.joinToString(","),
        headlineMain = headline.main,
        headlineKicker = headline.kicker,
        headlinePrint = headline.printHeadline,
        keywords = keywords.joinToString(","),
        pubDate = pubDate,
        newsDesk = newsDesk,
        sectionName = sectionName,
        subsectionName = subsectionName,
        byline = byline.original
    )
}

fun ArticleEntity.toArticle(): Article {
    val multimediaList =
        this.multimedia.split(", ") // Assuming multimedia is a comma-separated string
    val keywordList = this.keywords.split(", ") // Assuming keywords is a comma-separated string

    val docs = listOf(
        Article.Doc(
            webUrl = this.webUrl,
            snippet = this.snippet,
            leadParagraph = this.leadParagraph,
            source = this.source,
            multimedia = multimediaList.map { Article.Doc.Multimedia(url = it) },
            headline = Article.Doc.Headline(
                main = this.headlineMain,
                kicker = this.headlineKicker,
                printHeadline = this.headlinePrint
            ),
            keywords = keywordList.map { Article.Doc.Keyword(value = it) },
            pubDate = this.pubDate,
            newsDesk = this.newsDesk,
            sectionName = this.sectionName,
            subsectionName = this.subsectionName,
            byline = Article.Doc.Byline(original = this.byline)
        )
    )

    return Article(
        docs = docs,
        hits = 0
    )
}

