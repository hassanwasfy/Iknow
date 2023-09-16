package com.abaferas.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.abaferas.repository.models.entity.ArticleListEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleListDao {
    @Upsert
    fun insert(articleListEntity: ArticleListEntity)

    @Query("SELECT * FROM ArticleListEntity")
    fun getAllArticleLists(): Flow<List<ArticleListEntity>>

    @Query("SELECT * FROM ArticleListEntity WHERE id = :id")
    fun getArticleListById(id: Long): Flow<ArticleListEntity>

    @Delete
    fun delete(articleListEntity: ArticleListEntity)
}
