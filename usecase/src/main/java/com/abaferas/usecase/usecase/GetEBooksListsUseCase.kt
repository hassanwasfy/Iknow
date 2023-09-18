package com.abaferas.usecase.usecase

import com.abaferas.entities.Books
import com.abaferas.usecase.repositories.IRepository
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class GetEBooksListsUseCase @Inject constructor(
    private val iRepository: IRepository
) {
    suspend operator fun invoke(): Books = coroutineScope {
        try {
            iRepository.getBestSellerBooksEbook()
        } catch (e: Exception) {
            throw e
        }
    }
}
