package com.abaferas.iknow.di

import android.content.Context
import androidx.room.Room
import com.abaferas.local.room.IKnowDatabase
import com.abaferas.local.room.dao.ArticleListDao
import com.abaferas.local.room.dao.BooksEntityDao
import com.abaferas.local.room.dao.EntityArticleDao
import com.abaferas.local.room.dao.MostPopularDao
import com.abaferas.local.room.dao.TopStoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): IKnowDatabase {
        return Room.databaseBuilder(context, IKnowDatabase::class.java, "IKNOW_DATABASE").build()
    }

    @Singleton
    @Provides
    fun articleListDao(iKnowDatabase: IKnowDatabase): ArticleListDao {
        return iKnowDatabase.getArticleListDao()
    }

    @Singleton
    @Provides
    fun booksDao(iKnowDatabase: IKnowDatabase): BooksEntityDao {
        return iKnowDatabase.getBooksEntityDao()
    }

    @Singleton
    @Provides
    fun entityArticle(iKnowDatabase: IKnowDatabase): EntityArticleDao {
        return iKnowDatabase.getEntityArticleDao()
    }

    @Singleton
    @Provides
    fun mostPopDao(iKnowDatabase: IKnowDatabase): MostPopularDao {
        return iKnowDatabase.getMostPopularArticleEntityDao()
    }

    @Singleton
    @Provides
    fun topStoryDao(iKnowDatabase: IKnowDatabase): TopStoryDao {
        return iKnowDatabase.getTopStoriesEntityDao()
    }
}