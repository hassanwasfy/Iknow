package com.abaferas.local.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.abaferas.repository.models.entity.BooksEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BooksEntityDao {
    @Upsert
    fun insert(booksEntity: BooksEntity)

    @Query("SELECT * FROM BooksEntity")
    fun getAllBooks(): Flow<List<BooksEntity>>

    @Query("SELECT * FROM BooksEntity WHERE id = :id")
    fun getBookById(id: Long): Flow<BooksEntity>

    @Delete
    fun delete(booksEntity: BooksEntity)
}
