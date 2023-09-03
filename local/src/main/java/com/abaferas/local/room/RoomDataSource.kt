package com.abaferas.local.room

import com.abaferas.repository.models.entity.ArticleListEntity
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.EntityArticle
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.TopStoriesEntity
import com.abaferas.repository.source.LocalDataSource

class RoomDataSource : LocalDataSource {
    override suspend fun saveArticle(article: EntityArticle) {
        TODO("Not yet implemented")
    }

    override suspend fun getArticle(article: EntityArticle): List<EntityArticle> {
        TODO("Not yet implemented")
    }

    override suspend fun unSaveArticle(article: EntityArticle) {
        TODO("Not yet implemented")
    }

    override suspend fun saveBook(book: BooksEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getBook(book: BooksEntity): List<BooksEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun unSaveBook(book: BooksEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun saveList(list: ArticleListEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getList(list: ArticleListEntity): List<ArticleListEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun unSaveList(list: ArticleListEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun saveMostPopular(mostPopular: MostPopularArticleEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getMostPopular(mostPopular: MostPopularArticleEntity): List<MostPopularArticleEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun unSaveMostPopular(mostPopular: MostPopularArticleEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun saveTopStory(topStory: TopStoriesEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getTopStory(topStory: TopStoriesEntity): List<TopStoriesEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun unSaveTopStory(topStory: TopStoriesEntity) {
        TODO("Not yet implemented")
    }
}