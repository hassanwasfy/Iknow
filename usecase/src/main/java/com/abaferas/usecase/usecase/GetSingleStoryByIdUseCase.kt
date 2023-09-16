package com.abaferas.usecase.usecase

import com.abaferas.usecase.repositories.IRepository
import javax.inject.Inject

class GetSingleStoryByIdUseCase @Inject constructor(
    private val iRepository: IRepository
) {
    suspend operator fun invoke(section: String) {}
}