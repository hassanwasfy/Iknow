package com.abaferas.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.abaferas.repository.models.entity.MostPopularArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MostPopularDao {
    @Upsert
    fun insert(mostPopularArticleEntity: MostPopularArticleEntity)

    @Query("SELECT * FROM MostPopularArticleEntity")
    fun getAllMostPopularArticles(): Flow<List<MostPopularArticleEntity>>

    @Query("SELECT * FROM MostPopularArticleEntity WHERE id = :id")
    fun getMostPopularArticleById(id: Long): Flow<MostPopularArticleEntity>

    @Delete
    fun delete(mostPopularArticleEntity: MostPopularArticleEntity)
}
