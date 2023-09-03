package com.abaferas.repository.source

import com.abaferas.repository.models.entity.ArticleListEntity
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.EntityArticle
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.TopStoriesEntity

interface LocalDataSource {
    suspend fun saveArticle(article: EntityArticle)
    suspend fun getArticle(article: EntityArticle): List<EntityArticle>
    suspend fun unSaveArticle(article: EntityArticle)

    suspend fun saveBook(book: BooksEntity)
    suspend fun getBook(book: BooksEntity): List<BooksEntity>
    suspend fun unSaveBook(book: BooksEntity)

    suspend fun saveList(list: ArticleListEntity)
    suspend fun getList(list: ArticleListEntity): List<ArticleListEntity>
    suspend fun unSaveList(list: ArticleListEntity)

    suspend fun saveMostPopular(mostPopular: MostPopularArticleEntity)
    suspend fun getMostPopular(mostPopular: MostPopularArticleEntity): List<MostPopularArticleEntity>
    suspend fun unSaveMostPopular(mostPopular: MostPopularArticleEntity)

    suspend fun saveTopStory(topStory: TopStoriesEntity)
    suspend fun getTopStory(topStory: TopStoriesEntity): List<TopStoriesEntity>
    suspend fun unSaveTopStory(topStory: TopStoriesEntity)
}