package com.abaferas.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.abaferas.local.room.dao.*
import com.abaferas.repository.models.entity.ArticleEntity
import com.abaferas.repository.models.entity.ArticleListEntity
import com.abaferas.repository.models.entity.BooksEntity
import com.abaferas.repository.models.entity.Converters
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import com.abaferas.repository.models.entity.TopStoriesEntity

@Database(
    entities = [
        ArticleEntity::class,
        BooksEntity::class,
        ArticleListEntity::class,
        MostPopularArticleEntity::class,
        TopStoriesEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class IKnowRoomDatabase : RoomDatabase() {
    abstract fun articleDao(): EntityArticleDao
    abstract fun booksDao(): BooksEntityDao
    abstract fun articleListDao(): ArticleListDao
    abstract fun mostPopularDao(): MostPopularDao
    abstract fun topStoryDao(): TopStoryDao
}
