package com.abaferas.local.room

import com.abaferas.exception.IKnowException
import com.abaferas.local.room.dao.ArticleListDao
import com.abaferas.local.room.dao.BooksEntityDao
import com.abaferas.local.room.dao.EntityArticleDao
import com.abaferas.local.room.dao.MostPopularDao
import com.abaferas.local.room.dao.TopStoryDao
import com.abaferas.repository.models.entity.ArticleEntity
import com.abaferas.repository.models.entity.ArticleListEntity
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.TopStoriesEntity
import com.abaferas.repository.source.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomDataSource @Inject constructor(
    private val articleDao: EntityArticleDao,
    private val booksDao: BooksEntityDao,
    private val articleListDao: ArticleListDao,
    private val mostPopularDao: MostPopularDao,
    private val topStoryDao: TopStoryDao
) : LocalDataSource {

    private inline fun <T> tryToExecute(block: () -> T): T {
        return try {
            block()
        } catch (e: IKnowException) {
            throw e
        }
    }

    override suspend fun insertArticle(article: ArticleEntity) {
        tryToExecute {
            articleDao.insert(article)
        }
    }

    override suspend fun deleteArticle(article: ArticleEntity) {
        tryToExecute {
            articleDao.delete(article)
        }
    }

    override fun getAllArticles(): Flow<List<ArticleEntity>> {
        return articleDao.getAllArticles()
    }

    override suspend fun getArticleById(id: String): Flow<ArticleEntity> {
        return articleDao.getArticleById(id)
    }

    override suspend fun insertBook(booksEntity: BooksEntity) {
        tryToExecute {
            booksDao.insert(booksEntity)
        }
    }

    override suspend fun deleteBook(booksEntity: BooksEntity) {
        tryToExecute {
            booksDao.delete(booksEntity)
        }
    }

    override fun getAllBooks(): Flow<List<BooksEntity>> {
        return booksDao.getAllBooks()
    }

    override suspend fun getBookById(id: Long): Flow<BooksEntity> {
        return booksDao.getBookById(id)
    }

    override suspend fun insertArticleList(articleListEntity: ArticleListEntity) {
        tryToExecute {
            articleListDao.insert(articleListEntity)
        }
    }

    override suspend fun deleteArticleList(articleListEntity: ArticleListEntity) {
        tryToExecute {
            articleListDao.delete(articleListEntity)
        }
    }

    override fun getAllArticleLists(): Flow<List<ArticleListEntity>> {
        return articleListDao.getAllArticleLists()
    }

    override suspend fun getArticleListById(id: Long): Flow<ArticleListEntity> {
        return tryToExecute {
            articleListDao.getArticleListById(id)
        }
    }


    override suspend fun insertMostPopularArticle(mostPopularArticleEntity: MostPopularArticleEntity) {
        tryToExecute {
            mostPopularDao.insert(mostPopularArticleEntity)
        }
    }

    override suspend fun deleteMostPopularArticle(mostPopularArticleEntity: MostPopularArticleEntity) {
        tryToExecute {
            mostPopularDao.delete(mostPopularArticleEntity)
        }
    }

    override fun getAllMostPopularArticles(): Flow<List<MostPopularArticleEntity>> {
        return mostPopularDao.getAllMostPopularArticles()
    }

    override suspend fun getMostPopularArticleById(id: Long): Flow<MostPopularArticleEntity> {
        return mostPopularDao.getMostPopularArticleById(id)
    }

    override suspend fun insertTopStory(topStoriesEntity: TopStoriesEntity) {
        tryToExecute {
            topStoryDao.upsert(topStoriesEntity)
        }
    }

    override suspend fun deleteTopStory(topStoriesEntity: TopStoriesEntity) {
        tryToExecute {
            topStoryDao.delete(topStoriesEntity)
        }
    }

    override fun getAllTopStories(): Flow<List<TopStoriesEntity>> {
        return topStoryDao.getAllTopStories()
    }

    override suspend fun getTopStoryById(id: Long): Flow<TopStoriesEntity> {
        return topStoryDao.getTopStoryById(id)
    }
}
