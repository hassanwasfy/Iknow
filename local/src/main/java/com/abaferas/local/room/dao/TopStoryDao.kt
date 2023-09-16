package com.abaferas.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.abaferas.repository.models.entity.TopStoriesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TopStoryDao {
    @Upsert
    fun upsert(topStoryEntity: TopStoriesEntity)

    @Query("SELECT * FROM TopStoriesEntity")
    fun getAllTopStories(): Flow<List<TopStoriesEntity>>

    @Query("SELECT * FROM TopStoriesEntity WHERE id = :id")
    fun getTopStoryById(id: Long): Flow<TopStoriesEntity>

    @Delete
    fun delete(topStoryEntity: TopStoriesEntity)
}
