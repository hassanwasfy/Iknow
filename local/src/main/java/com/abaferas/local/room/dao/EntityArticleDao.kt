package com.abaferas.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.abaferas.repository.models.entity.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EntityArticleDao {
    @Upsert
    fun insert(articleEntity: ArticleEntity)

    @Query("SELECT * FROM ArticleEntity")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM ArticleEntity WHERE headlineMain = :headlineMain")
    fun getArticleById(headlineMain: String): Flow<ArticleEntity>

    @Delete
    fun delete(articleEntity: ArticleEntity)
}
