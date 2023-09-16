package com.abaferas.usecase.usecase.local

import com.abaferas.entities.Books
import com.abaferas.usecase.repositories.ILocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class BooksEntityUseCase @Inject constructor(
    private val localRepository: ILocalRepository
) {

    suspend fun insertBook(book: Books) {
        localRepository.insertBook(book)
    }

    suspend fun deleteBook(book: Books) {
        localRepository.deleteBook(book)
    }

    fun getAllBooks(): Flow<List<Books>> {
        return localRepository.getAllBooks()
    }

    suspend fun getBookById(id: Long): Books {
        return localRepository.getBookById(id).single()
    }
}