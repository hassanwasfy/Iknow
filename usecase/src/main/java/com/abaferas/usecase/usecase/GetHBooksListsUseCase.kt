package com.abaferas.usecase.usecase

import com.abaferas.entities.Books
import com.abaferas.usecase.repositories.IRepository
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetHBooksListsUseCase @Inject constructor(
    private val iRepository: IRepository
) {
    suspend operator fun invoke(): Books = coroutineScope {
        try {
            iRepository.getBestSellerBooksHandCover()
        } catch (e: Exception) {
            throw e
        }
    }
}