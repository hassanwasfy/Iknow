package com.abaferas.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.abaferas.local.room.dao.ArticleListDao
import com.abaferas.local.room.dao.BooksEntityDao
import com.abaferas.local.room.dao.EntityArticleDao
import com.abaferas.local.room.dao.MostPopularDao
import com.abaferas.local.room.dao.TopStoryDao
import com.abaferas.repository.models.entity.ArticleListEntity
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.EntityArticle
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.TopStoriesEntity

@Database(
    entities = [
        ArticleListEntity::class,
        BooksEntity::class,
        EntityArticle::class,
        MostPopularArticleEntity::class,
        TopStoriesEntity::class], version = 1
)
abstract class IKnowDatabase : RoomDatabase() {
    abstract fun getArticleListDao(): ArticleListDao
    abstract fun getBooksEntityDao(): BooksEntityDao
    abstract fun getEntityArticleDao(): EntityArticleDao
    abstract fun getMostPopularArticleEntityDao(): MostPopularDao
    abstract fun getTopStoriesEntityDao(): TopStoryDao
}