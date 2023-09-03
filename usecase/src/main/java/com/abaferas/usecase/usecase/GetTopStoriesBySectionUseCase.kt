package com.abaferas.usecase.usecase

import com.abaferas.entities.TopStories
import com.abaferas.usecase.repositories.IRepository
import javax.inject.Inject

class GetTopStoriesBySectionUseCase @Inject constructor(
    private val iRepository: IRepository
) {
    suspend operator fun invoke(section: String): TopStories {
        return iRepository.getTopStories(section)
    }
}