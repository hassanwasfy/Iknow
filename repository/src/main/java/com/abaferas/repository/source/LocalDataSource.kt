package com.abaferas.repository.source

import com.abaferas.repository.models.entity.ArticleEntity
import com.abaferas.repository.models.entity.ArticleListEntity
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.TopStoriesEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    //region EntityArticleDao
    suspend fun insertArticle(article: ArticleEntity)

    suspend fun deleteArticle(article: ArticleEntity)

    fun getAllArticles(): Flow<List<ArticleEntity>>
    suspend fun getArticleById(id: String): Flow<ArticleEntity>
    //endregion

    //region BooksEntityDao
    suspend fun insertBook(booksEntity: BooksEntity)

    suspend fun deleteBook(booksEntity: BooksEntity)

    fun getAllBooks(): Flow<List<BooksEntity>>
    suspend fun getBookById(id: Long): Flow<BooksEntity>
    //endregion

    //region ArticleListDao
    suspend fun insertArticleList(articleListEntity: ArticleListEntity)

    suspend fun deleteArticleList(articleListEntity: ArticleListEntity)

    fun getAllArticleLists(): Flow<List<ArticleListEntity>>
    suspend fun getArticleListById(id: Long): Flow<ArticleListEntity>
    //endregion

    //region MostPopularDao
    suspend fun insertMostPopularArticle(mostPopularArticleEntity: MostPopularArticleEntity)

    suspend fun deleteMostPopularArticle(mostPopularArticleEntity: MostPopularArticleEntity)

    fun getAllMostPopularArticles(): Flow<List<MostPopularArticleEntity>>
    suspend fun getMostPopularArticleById(id: Long): Flow<MostPopularArticleEntity>
    //endregion

    //region TopStoryDao
    suspend fun insertTopStory(topStoriesEntity: TopStoriesEntity)

    suspend fun deleteTopStory(topStoriesEntity: TopStoriesEntity)

    fun getAllTopStories(): Flow<List<TopStoriesEntity>>
    suspend fun getTopStoryById(id: Long): Flow<TopStoriesEntity>
    //endregion
}
